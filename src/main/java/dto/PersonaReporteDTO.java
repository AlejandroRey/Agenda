package dto;

import java.sql.Date;

public class PersonaReporteDTO implements Comparable<PersonaReporteDTO> {
	
	private String nombre;
	private String telefono;
	private String email;
	private Date fechaDeNacimiento;
	private String calle;
	private int altura;
	private int piso;
	private int departamento;
	private String localidad;	
	private String tipoDeContacto;
	private String splitNombre;
	private String splitApellido;
	private String splitMailServer;
	
	public PersonaReporteDTO(String nombre, String telefono, String email, Date fechaDeNacimiento, String calle,
			int altura, int piso, int departamento, String localidad, String tipoDeContacto, String splitNombre,
			String splitApellido, String splitMailServer) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
		this.tipoDeContacto = tipoDeContacto;
		this.splitNombre = splitNombre;
		this.splitApellido = splitApellido;
		this.splitMailServer = splitMailServer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTipoDeContacto() {
		return tipoDeContacto;
	}

	public void setTipoDeContacto(String tipoDeContacto) {
		this.tipoDeContacto = tipoDeContacto;
	}

	public String getSplitNombre() {
		return splitNombre;
	}

	public void setSplitNombre(String splitNombre) {
		this.splitNombre = splitNombre;
	}

	public String getSplitApellido() {
		return splitApellido;
	}

	public void setSplitApellido(String splitApellido) {
		this.splitApellido = splitApellido;
	}

	public String getSplitMailServer() {
		return splitMailServer;
	}

	public void setSplitMailServer(String splitMailServer) {
		this.splitMailServer = splitMailServer;
	}

	@Override
	public int compareTo(PersonaReporteDTO o) {
		// TODO Auto-generated method stub
		//return this.splitApellido.compareTo(o.splitApellido);
		return this.nombre.compareTo(o.nombre);
	}

}
