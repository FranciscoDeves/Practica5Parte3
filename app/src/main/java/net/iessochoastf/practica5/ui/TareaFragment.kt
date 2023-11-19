package net.iessochoastf.practica5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import net.iessochoastf.practica5.databinding.FragmentListaBinding
import net.iessochoastf.practica5.databinding.FragmentTareaBinding
import net.iessochoastf.practica5.R
import android.widget.ArrayAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TareaFragment : Fragment() {

    private var _binding: FragmentTareaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTareaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Tu lógica aquí

        iniciaSpCategoria()

    }


    //Añadimos el metodo

    private fun iniciaSpCategoria() {
        ArrayAdapter.createFromResource(
        //contexto suele ser la Activity
            requireContext(),
        //array de strings
            R.array.categoria,
        //layout para mostrar el elemento seleccionado
            android.R.layout.simple_spinner_item
        ).also { adapter ->
        // Layout para mostrar la apariencia de la lista
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // asignamos el adaptador al spinner
            binding.spCategoria.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
