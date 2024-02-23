package com.example.mvvm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Retrofit

import com.example.mvvm.api.ClientApi
import com.example.mvvm.databinding.FragmentListBinding
import com.example.mvvm.model.Item
import kotlinx.coroutines.launch
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "ListFragment"
class ListFragment : Fragment() {
    private lateinit var list: List<Item>
    private var _binding: FragmentListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        binding.rvList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val clientApi: ClientApi = retrofit.create<ClientApi>(ClientApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = clientApi.fetchResponse()
                Log.d(TAG, "Response received: $response")
                list = response.items?: emptyList()
                binding.rvList.adapter = SearchAdapter(list)
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
