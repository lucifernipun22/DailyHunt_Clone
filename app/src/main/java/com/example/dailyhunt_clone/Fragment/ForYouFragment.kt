package com.example.dailyhunt_clone.Fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhunt_clone.Data.NewsResponseDTO
import com.example.dailyhunt_clone.R
import com.example.dailyhunt_clone.UI.Adapter.NewsAdapter
import com.tejeet.retrofitkotlin.ApiClient
import com.tejeet.retrofitkotlin.Network.Network
import kotlinx.android.synthetic.main.fragment_for_you.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ForYouFragment : Fragment() {
    var v: View? = null

    private val TAG = "tag"
    private lateinit var mAdapter: NewsAdapter
    private var newsList: List<NewsResponseDTO> = listOf()

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_for_you, container, false)
        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        setRecyclerAdatapter()
        pbProgressbar.visibility = View.VISIBLE
        rcvforyounews.visibility = View.GONE
        callApi()
    }

    companion object {
        fun newInstance(): ForYouFragment {
            return ForYouFragment()
        }
    }

    private fun setRecyclerAdatapter() {
        mAdapter = NewsAdapter(newsList)
        val LinearLayoutManager = LinearLayoutManager(context)
        rcvforyounews.layoutManager = LinearLayoutManager
        rcvforyounews.adapter = mAdapter

    }

    private fun callApi() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getNews()
            .enqueue(object : Callback<List<NewsResponseDTO>> {

                override fun onResponse(call: Call<List<NewsResponseDTO>>, response: Response<List<NewsResponseDTO>>) {
                    pbProgressbar.visibility = View.GONE
                    rcvforyounews.visibility = View.VISIBLE

                    Log.d(TAG, "onResponse: Response is : $response")
                    response.body()?.let {
                        newsList = it
                        mAdapter.updateData(newsList)
                    }
                }

                override fun onFailure(call: Call<List<NewsResponseDTO>>, t: Throwable) {
                    Log.d(TAG, "Data Loading Failed: ")
                }

            })
    }




}