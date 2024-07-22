using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    public int finalScore;
    public float playTime;


    public void ToStart() // "Main" 씬으로 이동
    {
        SceneManager.LoadScene("Main");
    }

    public void ToGame() // "Game" 씬으로 이동
    {
        SceneManager.LoadScene("Game");
    }

    public void ToScore() // "Score" 씬으로 이동
    {
        PlayerPrefs.SetInt("Score", finalScore);
        SceneManager.LoadScene("Score");
    }
}