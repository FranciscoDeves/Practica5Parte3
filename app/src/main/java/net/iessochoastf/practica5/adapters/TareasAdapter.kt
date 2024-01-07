package net.iessochoastf.practica5.adapters
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.iessochoastf.practica5.databinding.ItemTareaBinding
import net.iessochoastf.practica5.model.Tarea

/*
class TareasAdapter () {

    var listaTareas: List<Tarea>?=null
    fun setLista(lista:List<Tarea>){
        listaTareas=lista
    //notifica al adaptador que hay cambios y tiene que redibujar el
     //ReciclerView
        notifyDataSetChanged()
    }

    inner class TareaViewHolder(val binding: ItemTareaBinding)
        : RecyclerView.ViewHolder(binding.root)







}

 */

class TareasAdapter (private val listaTareas: List<Tarea>)
    :RecyclerView.Adapter<TareasAdapter.TareaViewHolder>(){
    inner class TareaViewHolder(val binding: ItemTareaBinding)
        :RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): TareaViewHolder {
        TODO("Not yet implemented")
    }
    override fun onBindViewHolder(holder: TareaViewHolder,
                                  position: Int) {
        TODO("Not yet implemented")
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}