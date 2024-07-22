using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TriggerWall : MonoBehaviour
{
    private readonly float speed = 8.0f; // 벽 이동 속도
    private GameScene gs;
    private bool fin = false; // 점수 및 생명 업데이트 여부

    void Start()
    {
        gs = GameObject.Find("GameManager").GetComponent<GameScene>(); // GameScene 컴포넌트 가져오기
    }

    void Update()
    {
        gameObject.transform.Translate(Vector3.up * speed * Time.deltaTime); // 벽 이동

        if (!fin && transform.position.z > -15)
        {
            if (!gs.getPoint)
            {
                gs.UpdateScore(); // 점수 업데이트
            }
            if (gs.getPoint)
            {
                fin = true;
                gs.getPoint = false;
            }
        }

        if (!fin && transform.position.z > 0 && gs.colliders.Count == 0)
        {
            if (!gs.getPoint)
            {
                gs.CountLife(); // 생명 감소
            }
            fin = true;
            gs.getPoint = false;
        }

        if (transform.position.z > 10)
        {
            Destroy(gameObject); // 벽 삭제
        }
    }
}
