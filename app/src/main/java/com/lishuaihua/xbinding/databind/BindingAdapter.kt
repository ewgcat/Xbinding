package com.lishuaihua.xbinding.databind

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.User
import com.lishuaihua.xbinding.databind.list.Product
import com.lishuaihua.xbinding.databind.list.ProductAdapter


@BindingAdapter("bindingImage")
fun bindingImage(imageView: ImageView, url: String?) {

}

@BindingAdapter("bindingLiveData")
fun bindingLiveData(textView: TextView, user: User?) {
    user?.apply {
        textView.setText("@BindingAdapter + LiveData + parcelize 示例 ")
    }

}

@BindingAdapter("bindList")
fun bindAdapterList(recyclerView: RecyclerView, data: List<Product>?) {
    val adapter = recyclerView.adapter as? ProductAdapter
        ?: throw RuntimeException("adapter must bu not null")
    data?.let {
        adapter.submitList(it)
        adapter.notifyDataSetChanged()
    }
}