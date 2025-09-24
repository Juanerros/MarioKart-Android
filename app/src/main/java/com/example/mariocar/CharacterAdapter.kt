import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mariocar.Character
import com.example.mariocar.R

// Adapter: conecta los datos con el RecyclerView
class CharacterAdapter(private val lista: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.PersonajeViewHolder>() {
    // ViewHolder: mantiene las referencias a las vistas de cada item para optimizar
    class PersonajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPersonaje: ImageView = itemView.findViewById(R.id.imgPersonaje)
        val txtNombre: TextView = itemView.findViewById(R.id.txtNombre) // Nombre del personaje
        val txtVida: TextView = itemView.findViewById(R.id.txtVida) // Vida del personaje
        val txtVelocidad: TextView = itemView.findViewById(R.id.txtVelocidad) // Velocidad del
        val txtAceleracion: TextView = itemView.findViewById(R.id.txtAceleracion) // Aceleración
    }
    // Se llama para crear nuevas vistas (ViewHolders) cuando no hay suficientes recicladas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false) // Infla el layout de cada item
        return PersonajeViewHolder(vista) // Devuelve el ViewHolder con la vista inflada
    }
    // Se llama para mostrar los datos en cada ViewHolder
    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val personaje = lista[position] // Obtiene el personaje correspondiente a la posición
        holder.imgPersonaje.setImageResource(personaje.imagen) // Asigna la imagen
        holder.txtNombre.text = personaje.nombre // Asigna el nombre
        holder.txtVida.text = "Vida: ${personaje.vida}" // Asigna la vida
        holder.txtVelocidad.text = "Velocidad: ${personaje.velocidad}" // Asigna la velocidad
        holder.txtAceleracion.text = "Aceleración: ${personaje.aceleracion}" // Asigna la aceleración
// Evento al hacer click en el item
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Click en ${personaje.nombre}",

                Toast.LENGTH_SHORT).show()
        }
    }
    // Devuelve la cantidad total de elementos de la lista
    override fun getItemCount(): Int = lista.size
}