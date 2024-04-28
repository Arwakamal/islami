package com.route.week4_islami.ui.home.radio



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.gson.Gson

import com.route.week4_islami.api.ApiManager
import com.route.week4_islami.api.modal.radiosResponse.RadioItem
import com.route.week4_islami.api.modal.radiosResponse.RadiosItemsResponse
import com.route.week4_islami.databinding.FragmentRadioBinding
import retrofit2.Call
import retrofit2.Response


class RadioFragment :Fragment() {
    lateinit var viewBinding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentRadioBinding.inflate(inflater,container,false)
        return  viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.errorView.isVisible =false
        getRadiosItems()
    }

    private fun showRadiosItems(radios: List<RadioItem>?) {
        viewBinding.errorView.isVisible =false
        viewBinding.progressBar.isVisible =false
        viewBinding.radioTv.isVisible =true
        viewBinding.radioAudioController.isVisible =true
        viewBinding.radioImage.isVisible =true
        radios?.forEach {
            radioItem ->
            radioItem.id
            radioItem.url
            radioItem.name
        }

    }
    private fun initViews(){
        viewBinding.tryAgain.setOnClickListener {
            getRadiosItems()
        }
    }
    fun changeLoadingVisibility(isLoadingVisible:Boolean){
        viewBinding.progressBar.isVisible =isLoadingVisible

    }

    private fun getRadiosItems() {
        changeLoadingVisibility(true)
        ApiManager
            .getServices()
            .getRadioApis()
            .enqueue(object :retrofit2.Callback<RadiosItemsResponse>{
                // server response with error
                // response
                override fun onResponse(
                    call: Call<RadiosItemsResponse>,
                    response: Response<RadiosItemsResponse>
                ) {


                    // response.message() message of (http response)
                    // 401 unauthorized
                    // success 200
                    if (response.isSuccessful){
                        showRadiosItems(response.body()?.radios)
                        return
                    }
                    // response.body( come from server(json)
                    // response.body().message() message from server
                    // anything else 200 response in error body
                    val responseJson =response.errorBody()?.string()
                    val errorResponse =
                        Gson().fromJson(responseJson,RadiosItemsResponse::class.java)
                    showError(errorResponse.toString())

                }
                // cant reach to server
                override fun onFailure(call: Call<RadiosItemsResponse>, t: Throwable) {
                  changeLoadingVisibility(false)
                    showError(t.message)
                }


            }

            )
    }

    private fun showError(message: String?) {
        viewBinding.errorView.isVisible =true
        viewBinding.errorMessage.text =message
        viewBinding.radioTv.isVisible =false
        viewBinding.radioAudioController.isVisible =false
        viewBinding.radioImage.isVisible =false

    }
}