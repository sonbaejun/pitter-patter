using UnityEngine;
using TMPro;

public class ViewWall : MonoBehaviour
{
    public GameObject[] wall; // 벽 오브젝트 배열
    private int nowWall; // 현재 벽 인덱스
    private float nextWallTime = 0f; // 다음 벽 생성 시간
    private float preTime; // 이전 시간

    void Start()
    {
        preTime = Time.time; // 초기 시간 설정
    }

    void Update()
    {
        // 일정 시간이 지나면 벽 생성
        if (Time.time - preTime > nextWallTime)
        {
            nowWall = Random.Range(0, wall.Length); // 랜덤 벽 선택
            nextWallTime = Random.Range(6, 9); // 다음 벽 생성 시간 설정
            // 벽 생성 (x, y, z)
            Instantiate(wall[nowWall], new Vector3(40, 4.3f, 0), Quaternion.Euler(0, -90, 0) * wall[nowWall].transform.rotation);
            preTime = Time.time; // 현재 시간 갱신
        }
    }
}
