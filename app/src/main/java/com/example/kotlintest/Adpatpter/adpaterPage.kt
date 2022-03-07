package com.example.kotlintest.Adpatpter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.MoudlePage.itemdata
import com.example.kotlintest.R
import com.example.kotlintest.ScendPage.ScendPage
import kotlinx.android.synthetic.main.action_item.view.*


//our main Adapter //it take MutableList of itemdata //and its extend RecyclerView Adapter // and contect to deal with intent
class adpaterPage(private val items: MutableList<itemdata>, private val context:Context,
                  private val statis:Int,private var displaymod:Boolean) :
    RecyclerView.Adapter<adpaterPage.itemViewHolder>() {

// here is The Holder // it take View to get  action_item
    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        return itemViewHolder(
            //so here is we did inflate to our action item and to deal with it
            LayoutInflater.from(parent.context).inflate(R.layout.action_item, parent, false)
        )
    }

    fun addItems(data: itemdata) {
        items.add(data)
        notifyItemInserted(items.size-1)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        //here we bind our data
        val CurrentItem = items[position]

        // we used kotinX lib to use synthetic  and use apply so That we dont we reaptat some of code
        holder.itemView.apply {
            itemTextView.text = CurrentItem.Title
            ItemCheckdBox.isChecked = CurrentItem.IsChecked
            itemTextView.setOnClickListener(View.OnClickListener {
                if( ItemCheckdBox.isChecked)
                {
                    displaymod=true;
                }
                val intent = Intent(context, ScendPage::class.java).apply {
                    putExtra("statis", statis)
                    putExtra("mod",displaymod)
                }

                context.startActivity(intent)
                if (context is Activity) {
//          (context as Activity).finish()
                }


            })
            if(holder.adapterPosition<=statis)
            {
               holder.itemView.isVisible=true;
            }
            else
            {
                holder.itemView.isVisible=false;
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size;
    }


}