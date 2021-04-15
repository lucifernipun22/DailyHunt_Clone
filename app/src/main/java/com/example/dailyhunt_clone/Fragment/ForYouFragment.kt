package com.example.dailyhunt_clone.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhunt_clone.Api.Adapter
import com.example.dailyhunt_clone.Api.Article
import com.example.dailyhunt_clone.Api.Source
import com.example.dailyhunt_clone.R


class ForYouFragment : Fragment() {
    var v: View? = null
    var recyclerView: RecyclerView? = null
    var listCont: List<Article>? = null

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_for_you, container, false)

        recyclerView = v!!.findViewById<View>(R.id.rvForYou) as RecyclerView
        val viewAdapter = Adapter(listCont,context )
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = viewAdapter
        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listCont = ArrayList()
        (listCont as ArrayList<Article>).add(Article("Mahadi Hasan", "01717677540"))
        (listCont as ArrayList<Article>).add(Article("Mahadi Hasan", "01717677540"))
        (listCont as ArrayList<Article>).add(Article("Mahadi Hasan", "01717677540"))

    }

    companion object {
        fun newInstance(): ForYouFragment {
            return ForYouFragment()
        }
    }


}