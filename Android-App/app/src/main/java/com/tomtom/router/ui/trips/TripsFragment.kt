package com.tomtom.router.ui.trips

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomtom.router.R
import com.tomtom.router.dagger.inject
import com.tomtom.router.data.trips.TripItem
import com.tomtom.router.databinding.FragmentTripsBinding
import com.tomtom.router.ui.ScopedFragment
import com.tomtom.router.ui.trips.adapter.TripItemAdapter
import javax.inject.Inject

class TripsFragment : ScopedFragment(), TripItemAdapter.TripItemClickListener {

    private lateinit var binding: FragmentTripsBinding
    private lateinit var mContext: Context

    @Inject
    lateinit var tripViewModel: TripViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTripItemAdapter(this)

        binding.toolbar.title = getString(R.string.menu_trips)
    }

    override fun onTripItemClicked(tripItem: TripItem) {
        Toast.makeText(requireContext(), tripItem.city, Toast.LENGTH_LONG).show()
    }

    private fun setupTripItemAdapter(listener: TripItemAdapter.TripItemClickListener) {
        val viewManager = LinearLayoutManager(activity)
        val viewAdapter = TripItemAdapter(listener)

        binding.recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        tripViewModel.tripItems.observe(viewLifecycleOwner, Observer { tripItems ->
            viewAdapter.submitList(tripItems)
        })
    }
}