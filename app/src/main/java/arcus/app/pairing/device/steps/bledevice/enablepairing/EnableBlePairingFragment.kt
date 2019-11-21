/*
 *  Copyright 2019 Arcus Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package arcus.app.pairing.device.steps.bledevice.enablepairing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arcus.app.R
import arcus.app.common.fragment.TitledFragment
import arcus.app.pairing.device.steps.bledevice.EnableBlePairingStep


class EnableBlePairingFragment : Fragment(),
    TitledFragment, EnableBlePairingStep {
    private lateinit var pairingDevice : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ble_enable_pairing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            pairingDevice = bundle.getString(ARG_DEVICE_NAME)!!
        }
    }

    override fun getTitle(): String = pairingDevice

    companion object {
        private const val ARG_DEVICE_NAME = "ARG_DEVICE_NAME"
        @JvmStatic
        fun newInstance(shortName: String) = EnableBlePairingFragment().also {
            with(Bundle()) {
                putString(ARG_DEVICE_NAME, shortName)
                it.arguments = this
            }
        }
    }
}
