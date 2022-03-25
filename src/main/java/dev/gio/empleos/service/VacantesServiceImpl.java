package dev.gio.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.gio.empleos.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService{

	private List<Vacante> lista = null;
	
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		
		Vacante vac1 = new Vacante();
		Vacante vac2 = new Vacante();
		Vacante vac3 = new Vacante();
		Vacante vac4 = new Vacante();
		
		try {
			
			vac1.setId(1);
			vac1.setNombre("Ingeniero Civil");
			vac1.setDescripcion("Se solicita un Ing. Civil para el diseño de un puente peatonal.");
			vac1.setFecha(sdf.parse("28-08-2021"));
			vac1.setSalario(40000.0);
			vac1.setDestacado(0);
			vac1.setImagen("w.png");
			vac1.setEstatus("Aprobada");
			
			vac2.setId(2);
			vac2.setNombre("Contador Público");
			vac2.setDescripcion("Estamos en busqueda de un Contador Publico para llevar una nómina de importante empresa de software");
			vac2.setFecha(sdf.parse("22-03-2021"));
			vac2.setSalario(15000.0);
			vac2.setDestacado(1);
			vac2.setImagen("circle.jpg");
			vac2.setEstatus("Eliminada");
			
			vac3.setId(3);
			vac3.setNombre("Ingeniero Eléctrico");
			vac3.setDescripcion("Solicitamos un Ingeniero Eléctrico para el mantenimiento de instalación eléctrica de un edificio de 20 pisos");
			vac3.setFecha(sdf.parse("15-05-2021"));
			vac3.setSalario(23000.0);
			vac3.setDestacado(0);
			vac3.setImagen("global_marketing.png");
			vac3.setEstatus("Creada");
			
			vac4.setId(4);
			vac4.setNombre("Ingeniero Químico");
			vac4.setDescripcion("Se solicita un Ingeniero Químico para la fabricación de estupefacientes");
			vac4.setFecha(sdf.parse("17-04-2021"));
			vac4.setSalario(85000.0);
			vac4.setDestacado(1);
			vac4.setEstatus("Creada");
			//vac4.setImagen("samsung.jpg");
			
			lista.add(vac1);
			lista.add(vac2);
			lista.add(vac3);
			lista.add(vac4);
			
		} catch(ParseException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	@Override
	public List<Vacante> buscarTodas() {
		
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		
		lista.add(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {
//		Este metodo ya no se usa ya que usamos el de JPA
		return null;
	}

	
	
}
