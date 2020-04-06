package mx.ine.reclutaseycae.central.as;

public interface ASOperacionesSpringDataInterface {
	
	public void operacionGuardar();
	public void operacionActualizar();
	public void operacionBorrar();	
	
	public void ejecutarBusquedaCompuesta();
	public void ejecutarQueryDTOEntidad();
	
	public void ejecutarQueryDTOSinEntidad();

}
