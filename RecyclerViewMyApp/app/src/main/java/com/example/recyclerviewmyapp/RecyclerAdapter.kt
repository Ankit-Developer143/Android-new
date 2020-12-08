package com.example.recyclerviewmyapp

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter(data:ArrayList<CustomClass>,internal var context: Context):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


    //3rd steps Constructor
    internal var data:List<CustomClass>

    init {
        this.data = data
    }
//Step 3
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_item_list,parent,false)
        return ViewHolder(layout)
    }

    //step 4
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].item_title
        holder.image.setImageResource(data[position].item_image)
        holder.card.setOnClickListener{
            val alert = Dialog(context)
            alert.setContentView(R.layout.alert)

            alert.window!!.setType(WindowManager.LayoutParams.TYPE_TOAST)
            alert.setTitle("Android Development")
            val title=alert.findViewById<TextView>(R.id.alert_title)
            val image = alert.findViewById<CircleImageView>(R.id.alert_image)
            val done =alert.findViewById<Button>(R.id.done_btn)
            title.text=data[position].item_title
            image.setImageResource(data[position].item_image)
            alert.show()

            done.setOnClickListener {
                alert.dismiss()
            }

        }


    }

    //step 5
    override fun getItemCount(): Int {
        return data.size
    }




   //Second Steps
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        internal  var title:TextView
        internal var image:CircleImageView
        internal  var card:CardView

        init{
            title = itemView.findViewById(R.id.item_title)
            image = itemView.findViewById(R.id.item_image)
            card = itemView.findViewById(R.id.card)

        }

    }



}
