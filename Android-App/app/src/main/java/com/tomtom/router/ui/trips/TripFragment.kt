package com.tomtom.router.ui.trips

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tomtom.router.dagger.inject
import com.tomtom.router.databinding.FragmentTripsBinding
import com.tomtom.router.ui.ScopedFragment
import javax.inject.Inject

class TripFragment : ScopedFragment() {

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
    }
}