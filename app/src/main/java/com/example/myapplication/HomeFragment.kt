package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // 뷰가 사라질때  즉 메모리에서 날라갈때 같이 날리기 위해 따로 빼두기
    private var fragmentHomeBinding : FragmentHomeBinding? = null


    companion object{
        const val TAG : String = "로그"
        //자기 자신을 반환 싱글턴 패턴
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
        private var count : Int = 0
    }

    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate()")
    }

    // 프레그먼트를 암고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onAttach()")
    }

    // 뷰가 생성 되었을 때
    // 프레그먼트와 레이아웃을 연결 시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "HomeFragment - onCreateView()")

//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//
//        return view
        // 프레그먼트 뷰 바인딩
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding

        if(count != 0){
            fragmentHomeBinding!!.homeFragmentTextView.text = count.toString()
        }

        fragmentHomeBinding!!.homeFragmentBtn.setOnClickListener {
            Log.d(TAG, "HomeFragment - 홈 프래그먼트 버튼 클릭")
            count++
            fragmentHomeBinding!!.homeFragmentTextView.text = count.toString()
        }

        return fragmentHomeBinding!!.root
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null
        super.onDestroyView()
    }

}