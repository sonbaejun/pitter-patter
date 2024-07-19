pipeline {
    agent any

    tools {
        nodejs 'nodejs'
        dockerTool 'docker'
    }

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials-id')
        DEPLOY_SERVER_CREDENTIALS = credentials('deploy-server-credentials-id')
        FTP_SERVER = credentials('ftp-server')
        DEPLOY_SERVER_USER = credentials('deploy-server-user')
        DEPLOY_SERVER_HOST = credentials('deploy-server-host')
    }

    stages {
      stage('Build Frontend') {
        steps {
          script {
            dir('frontend') {
              sh 'npm install'
              sh 'npm run build-vite'
            }
          }
        }
        post {
          success {
            archiveArtifacts artifacts: 'frontend/dist/**', allowEmptyArchive: true
          }
        }
      }

    stage('Deploy Frontend') {
        steps {
          script {
            withCredentials([usernamePassword(credentialsId: 'ftp-server-credentials-id', passwordVariable: 'FTP_PASSWORD', usernameVariable: 'FTP_USERNAME')]) {
              sh """
                        lftp -c "set ftp:ssl-allow no; set ftp:passive-mode yes; open -u ${FTP_USERNAME},${FTP_PASSWORD} ${FTP_SERVER}; mirror -R frontend/dist/ ./; bye"
                      """
            }
          }
        }
    }

      stage('Build and Push Backend Images') {
        steps {
          script {
            def backendDirs = sh(
                script: 'ls -d backend/*/',
                returnStdout: true
            ).trim().split('\n')

            for (backendDir in backendDirs) {
              if (backendDir.contains('@tmp')) {
                continue
              }

              def project_name = backendDir.split('/').last()

              dir(backendDir) {
                sh """
                  docker build -t ssafy-common-${project_name} .
                  docker login -u ${DOCKER_HUB_CREDENTIALS_USR} -p ${DOCKER_HUB_CREDENTIALS_PSW}
                  docker tag ssafy-common-${project_name} ${DOCKER_HUB_CREDENTIALS_USR}/ssafy-common-${project_name}:latest
                  docker push ${DOCKER_HUB_CREDENTIALS_USR}/ssafy-common-${project_name}:latest
                """
              }
            }
          }
        }
      }

      stage('Deploy Backend') {
        steps {
          script {
            withCredentials([sshUserPrivateKey(credentialsId: 'deploy-server-credentials-id', keyFileVariable: 'DEPLOY_KEY')]) {
              def backendDirs = sh(
                  script: 'ls -d backend/*/',
                  returnStdout: true
              ).trim().split('\n')

              def ingress_script = '''
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: pitter-patter-ingress
  namespace: pitter-patter
  annotations:
    kubernetes.io/ingress.class: "traefik"
    cert-manager.io/cluster-issuer: "letsencrypt"
    acme.cert-manager.io/http01-ingress-class: "traefik"
spec:
  rules:
  - host: pitter-patter.picel.net
    http:
      paths:
'''

              for (backendDir in backendDirs) {
                if (backendDir.contains('@tmp')) {
                  continue
                }

                def project_name = backendDir.split('/').last()

                def deploy_script = sh(
                  script: "cat ${backendDir}k8s/deployment.yaml",
                  returnStdout: true
                ).trim()

                def path = """
      - path: /api/${project_name}
        pathType: Prefix
        backend:
          service:
            name: ${project_name}
            port:
              number: 8080
                """

                ingress_script = ingress_script + path

                sh """
                  ssh -i ${DEPLOY_KEY} ${DEPLOY_SERVER_USER}@${DEPLOY_SERVER_HOST} "docker login -u ${DOCKER_HUB_CREDENTIALS_USR} -p ${DOCKER_HUB_CREDENTIALS_PSW}"
                  ssh -i ${DEPLOY_KEY} ${DEPLOY_SERVER_USER}@${DEPLOY_SERVER_HOST} "docker pull ${DOCKER_HUB_CREDENTIALS_USR}/ssafy-common-${project_name}:latest"
                  ssh -i ${DEPLOY_KEY} ${DEPLOY_SERVER_USER}@${DEPLOY_SERVER_HOST} "
                  if kubectl get deployment ${project_name} -n pitter-patter; then
                      kubectl rollout restart deployment ${project_name} -n pitter-patter;
                  else
                      echo 'deployment not found';
                      echo '${deploy_script}' > /tmp/deployment-${project_name}.yaml;
                      kubectl apply -f /tmp/deployment-${project_name}.yaml -n pitter-patter;
                  fi;"
                """
              }

              def tls = '''
  tls:
    - hosts:
      - pitter-patter.picel.net
      secretName: pitter-patter-tls
'''

              ingress_script = ingress_script + tls

              sh """
                ssh -i ${DEPLOY_KEY} ${DEPLOY_SERVER_USER}@${DEPLOY_SERVER_HOST} "echo '${ingress_script}' > /tmp/ingress-pitter-patter.yaml"
                ssh -i ${DEPLOY_KEY} ${DEPLOY_SERVER_USER}@${DEPLOY_SERVER_HOST} "kubectl apply -f /tmp/ingress-pitter-patter.yaml -n pitter-patter"
              """
            }
          }
        }
      }
    }
}
