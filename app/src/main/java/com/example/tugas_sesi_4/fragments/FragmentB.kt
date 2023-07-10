package com.example.tugas_sesi_4.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_sesi_4.R
import com.example.tugas_sesi_4.UserActivity
import com.example.tugas_sesi_4.UserAdapter
import com.example.tugas_sesi_4.Users
import com.example.tugas_sesi_4.fragments.adapters.ViewPagerAdapter

class FragmentB : Fragment() {
    private lateinit var adapter: UserAdapter
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>
    lateinit var imageId : Array<Int>
    lateinit var textNama : Array<String>
    lateinit var textEmail : Array<String>
    lateinit var textJurusan : Array<String>
    lateinit var textSemester : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        val layoutManager = LinearLayoutManager(context)
        userRecyclerView = view.findViewById(R.id.listPenggunaB)
        userRecyclerView.layoutManager = layoutManager
        userRecyclerView.setHasFixedSize(true)
        adapter = UserAdapter(userArrayList)
        userRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : UserAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(getActivity(), UserActivity::class.java)
                intent.putExtra("imageDetailFoto", userArrayList[position].imageFoto)
                intent.putExtra("textHeadingNama", userArrayList[position].textNama)
                intent.putExtra("textDetailNama", userArrayList[position].textNama)
                intent.putExtra("textDetailEmail", userArrayList[position].textEmail)
                intent.putExtra("textDetailJurusan", userArrayList[position].textJurusan)
                intent.putExtra("textDetailSemester", userArrayList[position].textSemester)
                startActivity(intent)
            }
        })
    }

    private fun dataInit() {
        userArrayList = arrayListOf<Users>()

        imageId = arrayOf(
            R.drawable.female,
            R.drawable.male2,
            R.drawable.male,
            R.drawable.male3,
            R.drawable.male1,
        )

        textNama = arrayOf(
            "Tini",
            "Tono",
            "Tino",
            "Toni",
            "Agus"
        )

        textEmail = arrayOf(
            "tini@mail.com",
            "tono@mail.com",
            "tino@mail.com",
            "toni@mail.com",
            "agus@mail.com"
        )

        textJurusan = arrayOf(
            "Sastra Inggris",
            "Teknik Mesin",
            "Kedokteran Hewan",
            "Farmasi",
            "Filsafat"
        )

        textSemester = arrayOf(
            "Semester 2",
            "Semester 6",
            "Semester 8",
            "Semester 4",
            "Semester 4"
        )

        for(i in imageId.indices) {
            val users = Users(imageId[i], textNama[i], textEmail[i], textJurusan[i], textSemester[i])
            userArrayList.add(users)
        }
    }
}