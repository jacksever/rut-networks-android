package ru.rutmitt.internetrequests.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.rutmitt.internetrequests.data.ApiResponse
import ru.rutmitt.internetrequests.databinding.ListItemBinding

class ApiResponseAdapter(private var items: List<ApiResponse>) :
    RecyclerView.Adapter<ApiResponseAdapter.ApiResponseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiResponseViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApiResponseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApiResponseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<ApiResponse>) {
        this.items = newData
        notifyDataSetChanged()
    }

    class ApiResponseViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(apiResponse: ApiResponse) {
            with(binding) {
                nameTextView.text = apiResponse.name ?: "-"
                usernameTextView.text = apiResponse.username ?: "-"
                emailTextView.text = apiResponse.email ?: "-"
                phoneTextView.text = apiResponse.phone ?: "-"
                websiteTextView.text = apiResponse.website ?: "-"
                companyNameTextView.text = apiResponse.company?.name ?: "-"
            }
        }
    }
}
