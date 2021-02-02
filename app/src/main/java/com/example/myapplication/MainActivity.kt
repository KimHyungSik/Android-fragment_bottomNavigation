package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    //
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    
    companion object{
        const val TAG : String = "로그"
   }

    // 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //레이아웃과 연결
        setContentView(R.layout.activity_main)
        
        Log.d(TAG, "MainActivity - onCreate()")
        
        bottom_nav.setOnNavigationItemSelectedListener(this)

        //싱글턴 패턴
        homeFragment = HomeFragment.newInstance()
        //프레그먼트 추가
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()
    }

    // 인터페이스 없이 선언 후 사용 가능
    // 바텀네비게이션 아이템 클릭 리스너 설정
//    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
//        when(it.itemId){
//            R.id.menu_home ->{
//                Log.d(TAG, "MainActivity - 홈버튼 클릭")
//            }
//            R.id.menu_ranking ->{
//                Log.d(TAG, "MainActivity - 랭킹버튼 클릭")
//            }
//            R.id.menu_profile -> {
//                Log.d(TAG, "MainActivity - 프로필버튼 클릭")
//            }
//        }
//
//        true
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "MainActivity - onNavigationItemSelected()")

        when(item.itemId){
            R.id.menu_home ->{
                Log.d(TAG, "MainActivity - 홈버튼 클릭")
                //싱글턴 패턴
                homeFragment = HomeFragment.newInstance()
                //프레그먼트 교체
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_ranking ->{
                Log.d(TAG, "MainActivity - 랭킹버튼 클릭")
                //싱글턴 패턴
                rankingFragment = RankingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필버튼 클릭")
                //싱글턴 패턴
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
        }

        return true
    }

}