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
import kotlinx.coroutines.launch
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "ListFragment"
class ListFragment : Fragment() {
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
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val clientApi: ClientApi = retrofit.create<ClientApi>(ClientApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val response = clientApi.fetchContents()
            Log.d(TAG, "Response received: $response")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
