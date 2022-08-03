package com.example.virtusatest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemlist.view.*

class ListAdapter(val context: MainActivity, var arrayListPeople: ArrayList<GetPeople>, var arrayListRoom: ArrayList<GetRoomsData>) : RecyclerView.Adapter<ListAdapter.viewHolderList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)
        return viewHolderList(view)

    }

    override fun onBindViewHolder(holder: viewHolderList, position: Int) {
        if(arrayListPeople != null && arrayListRoom != null) {
                arrayListRoom.forEach {
                    for(people in arrayListPeople){
                        if(people.id == it.id){
                            holder.firstName.text = "FirstName : "+arrayListPeople.get(position).firstName
                            holder.lastName.text = "LastName : "+arrayListPeople.get(position).lastName
                            holder.favColor.text = "FavColor : "+arrayListPeople.get(position).favouriteColor
                            holder.jobTitle.text = "Designation : "+arrayListPeople.get(position).jobtitle
                            holder.emailId.text = "E-Mail : "+arrayListPeople.get(position).email
                            holder.maxOccupancy.text = "Occupancy : "+arrayListRoom.get(position).maxOccupancy
                            holder.isOccupied.text = "Availability : "+arrayListRoom.get(position).isOccupied

                            val picasso = Picasso.get()
                            picasso?.load(arrayListPeople.get(position).avatar)?.error(R.drawable.ic_person)?.into(holder.isAvatar)
                            holder.createAt.text ="CreatedAt : "+
                                Utils.setDateFormate(arrayListPeople.get(position).createdAt)
                        }

                    }
                }
        }

    }

    override fun getItemCount(): Int {
       return arrayListPeople.size
    }
    class viewHolderList(val containerView : View):RecyclerView.ViewHolder(containerView){
        val firstName = containerView.txt_firstName
        val lastName = containerView.txt_lastName
        val createAt = containerView.txt_createAt
        val emailId = containerView.txt_emailId
        val isAvatar = containerView.txt_isDraft
        val favColor = containerView.txt_favColor
        val jobTitle = containerView.txt_title
        val maxOccupancy = containerView.txt_maxOccupancy
        val isOccupied = containerView.txt_isOccupied

    }
}