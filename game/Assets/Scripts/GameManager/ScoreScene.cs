using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class ScoreScene : MonoBehaviour
{
    private GameManager gm;
    public float playTime;
    public Text playTimeTxt;
    public Text correctScoreTxt;

    void Start()
    {
        gm = transform.GetComponent<GameManager>(); // GameManager 컴포넌트 가져오기
        gm.finalScore = PlayerPrefs.GetInt("Score"); // 저장된 점수 불러오기
        correctScoreTxt.text = string.Format("{0:0}", gm.finalScore); // 점수 텍스트 업데이트
        // playTimeTxt.text = gm.playTimeTxt; // 점수 텍스트 업데이트
    }
}
