package com.example.anaworld.echo.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.anaworld.echo.R
import com.example.anaworld.echo.Songs

class MainScreenAdapter(_songDetails: ArrayList<Songs>, _context: Context) : RecyclerView.Adapter<MainScreenAdapter.MyViewHolder>() {

    var songDestails: ArrayList<Songs>? = null
    var mContext: Context? = null

    init {
        this.songDestails = _songDetails
        this.mContext = _context
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val songObject = songDestails?.get(position)
        holder?.trackTitle?.text = songObject?.songTitle
        holder?.trackArtist?.text = songObject?.artist
        holder?.contentHolder?.setOnClickListener({
            Toast.makeText(mContext, "Hey " + songObject?.songTitle, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_custom_mainscreen_adapter, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (songDestails == null) {
            return 0
        } else {
            return (songDestails as ArrayList<Songs>).size
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var trackTitle: TextView? = null
        var trackArtist: TextView? = null
        var contentHolder: RelativeLayout? = null

        init {
            trackArtist = view.findViewById<TextView>(R.id.trackArtist)
            trackTitle = view.findViewById<TextView>(R.id.trackTitle)
            contentHolder = view.findViewById<RelativeLayout>(R.id.contentRow)
        }
    }

}