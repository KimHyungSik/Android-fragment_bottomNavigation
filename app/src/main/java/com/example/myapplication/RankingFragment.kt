package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class RankingFragment : Fragment() {

    companion object{
        const val TAG : String = "로그"
        //자기 자신을 반환 싱글턴 패턴
        fun newInstance() : RankingFragment{
            return RankingFragment()
        }
    }

    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "RankingFragment - onCreate()")
    }

    // 프레그먼트를 암고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "RankingFragment - onAttach()")
    }

    // 뷰가 생성 되었을 때
    // 프레그먼트와 레이아웃을 연결 시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "RankingFragment - onCreateView()")

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        return view
    }

}