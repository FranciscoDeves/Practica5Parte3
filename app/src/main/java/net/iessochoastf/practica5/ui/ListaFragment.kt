package net.iessochoastf.practica5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import net.iessochoastf.practica5.databinding.FragmentListaBinding
import net.iessochoastf.practica5.R
import net.iessochoastf.practica5.model.Tarea
import net.iessochoastf.practica5.viewmodel.AppViewModel
import androidx.lifecycle.Observer


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!


    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tareasLiveData.observe(viewLifecycleOwner, Observer<List<Tarea>> { lista ->
            actualizaLista(lista)

        })



        // Este codigo es el que hacia que petase la app
        /*
        El estába en la llamada a findNavController().navigate(R.id.action_editar)
        en el OnClickListener del FAB (binding.fabNuevo.setOnClickListener).
        se estaba intentando navegar a un destino con un id específico (R.id.action_editar)
        sin proporcionar los argumentos requeridos para la transición.
         */

        binding.fabNuevo.setOnClickListener {
            // Crear acción para editar una nueva tarea, enviando un argumento nulo
            val action = ListaFragmentDirections.actionEditar(null)
            findNavController().navigate(action)
        }

         //para prueba, editamos una tarea aleatoria
        binding.btPruebaEdicion.setOnClickListener{
        //cogemos la lista actual de Tareas que tenemos en el ViewModel. No es lo más correcto
            val lista= viewModel.tareasLiveData.value
        //buscamos una tarea aleatoriamente
            val tarea=lista?.get((0..lista.lastIndex).random())
        //se la enviamos a TareaFragment para su edición
            val action=ListaFragmentDirections.actionEditar(tarea)
            findNavController().navigate(action)
        }

        iniciaFiltros()

    }

    private fun actualizaLista(lista: List<Tarea>?) {
        //creamos un string modificable
        val listaString = buildString {
            lista?.forEach() {
        //añadimos al final del string
                append(
                    "${it.id}-${it.tecnico}-${
        //mostramos un trozo de la descripción
                        if (it.descripcion.length < 21) it.descripcion
                        else
                            it.descripcion.subSequence(0, 20)
                    }-${
                        if (it.pagado) "SI-PAGADO" else
                            "NO-PAGADO"
                    }-" + when (it.estado) {
                        0 -> "ABIERTA"
                        1 -> "EN_CURSO"
                        else -> "CERRADA"
                    } + "\n"
                )
            }
        }
        binding.tvLista.setText(listaString)
    }
    //Declaramos el ViewModel para compartir datos entre fragments

   // activar el filtro cuando el usuario pulse en el switch
    private fun iniciaFiltros(){
        binding.swSinPagar.setOnCheckedChangeListener( ) { _,isChecked->
        //actualiza el LiveData SoloSinPagarLiveData que a su vez modifica tareasLiveData
        //mediante el Transformation
            viewModel.setSoloSinPagar(isChecked)}
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}




