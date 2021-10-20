package com.clearsky77.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      햄버거 아이콘 터치
        naviBtn.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START) // START: left, END: right 와 같은 의미. 왼쪽에서부터 열림.
        }

//      네비게이션 메뉴 터치
        naviView.setNavigationItemSelectedListener(this)
    }

//    네비게이션 메뉴의 아이템 각각 선택 시 수행할 것
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.myInfo -> Toast.makeText(applicationContext, "내정보", Toast.LENGTH_SHORT).show()
            R.id.schedule -> Toast.makeText(applicationContext, "스케줄", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers() // 선택이 끝났으니 네비게이션 메뉴 창은 닫아줘야한다.
        return false
    }
}