using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class ScoreScene : MonoBehaviour
{
    private GameManager gm;
    public TextMeshProUGUI correctScoreTxt;

    void Start()
    {
        gm = transform.GetComponent<GameManager>(); // GameManager 컴포넌트 가져오기
        gm.finalScore = PlayerPrefs.GetInt("Score"); // 저장된 점수 불러오기
        correctScoreTxt.text = "점수: " + gm.finalScore; // 점수 텍스트 업데이트
    }
}
