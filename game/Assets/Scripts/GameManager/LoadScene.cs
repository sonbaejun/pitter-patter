using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LoadScene : MonoBehaviour
{
    private GameManager gm;
    void Start()
    {
        gm = transform.GetComponent<GameManager>();
        PlayerPrefs.SetInt("Score", 0);
        gm.ToStart();
    }
}