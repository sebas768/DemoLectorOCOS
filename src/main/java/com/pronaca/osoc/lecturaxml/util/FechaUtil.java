package com.pronaca.osoc.lecturaxml.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FechaUtil {
	private static final Logger LOG = LoggerFactory.getLogger(FechaUtil.class);
	private static final long SEGUNDOS = 1000L;
	private static final long MINUTOS = 60L * SEGUNDOS;
	private static final long HORAS = 60L * MINUTOS;
	private static final long DIAS = 24L * HORAS;
	private static final long SEMANAS = 7L * DIAS;
	private static final long MESES = 30L * DIAS;
	private static final long ANNOS = 365L * DIAS;

	private static TimeZone timeZone = TimeZone.getTimeZone("GTM");

	public static Date getFechaActual() {
		return new Date();
	}

	public static String ajustarFormatoOcos(String fechaString) {
		SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");
		String format = ""; 
		String format1 = "dd-MMM-yy";
		String format2 = "yyyy-MM-dd";
		String format3 = "dd-MM-yyyy HH:mm:ss"; 
		if(fechaString.length() == format1.length()) {
			format=format1;
		}else if(fechaString.length() == format2.length()) {
			format=format2;
		}else if(fechaString.length() == format3.length()){
			format=format3;
		}
		try {
			if (fechaString != "" && format != "") {
				Date fechaDate = null;
				SimpleDateFormat formatInit = new SimpleDateFormat(format);
				fechaDate = formatInit.parse(fechaString);
				return fechaDate == null ? "" : formatterOut.format(fechaDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	public static String aplicarFromato(Date fecha, String formato) {
		SimpleDateFormat formatter = new SimpleDateFormat(formato, new Locale("es"));
		return fecha == null ? "" : formatter.format(fecha);
	}

	public static String getTiempoDuracion(Long tiempoInicio) {
		Double tiempo = (double) (System.currentTimeMillis() - tiempoInicio);
		tiempo = tiempo / (1000);
		DecimalFormat df = new DecimalFormat("#.00");
		String valueFormated = df.format(tiempo);
		return valueFormated + " s ";
	}

	/**
	 * M�todo que retorna el String de una fecha con el formato deseado
	 * 
	 * @param date
	 *            La fecha a la que se aplica el formato
	 * @param formato
	 *            El formato de la fecha
	 * @return El String de una fecha con el formato escogido
	 */
	public static String formatDate(Date date, String formato) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
		return simpleDateFormat.format(date);
	}

	/**
	 * M�todo que retorna el dia actual de una fecha
	 * 
	 * @param date
	 *            La fecha a la que se aplica el formato
	 * @return El String de una fecha con el formato escogido
	 */
	public static String obtenerDiaFecha(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date fecha = calendar.getTime();
		// Display a date in day, month, year format
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		// Formatting date with full day and month name and show time up to
		// milliseconds with AM/PM
		formatter = new SimpleDateFormat("EEEE");
		String today = formatter.format(fecha);
		return today;
	}

	/**
	 * M�todo que retorna la edad en a�os dada una fecha.
	 * 
	 * @author osmany.ce 07/05/2015
	 * @param fechaNacimiento
	 * @return
	 */
	public static int edadEnAnnos(Date fechaNacimiento) {
		// Fecha de nacimiento
		GregorianCalendar fechaNac = new GregorianCalendar();
		fechaNac.setTime(fechaNacimiento);
		// Fecha actual
		GregorianCalendar hoy = new GregorianCalendar();
		hoy.setTime(Calendar.getInstance().getTime());
		// Diferencia en annos
		int dif_annos = hoy.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		// Diferencia en meses
		int dif_meses = hoy.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		// Diferencia en dias
		int dif_dias = hoy.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		if ((dif_meses < 0) || ((dif_meses == 0) && (dif_dias < 0))) {
			dif_annos = dif_annos - 1;
		}
		return dif_annos;
	}

	/**
	 * M�todo que retorna si una fecha est� dentro (incluidos los extremos) de
	 * un rango de fechas. No se toma en cuenta la hora.
	 * 
	 * @author osmany.ce 07/05/2015
	 * @param iniDate
	 * @param endDate
	 * @param checkDate
	 * @return
	 */
	public static boolean estaEnRango(Date iniDate, Date endDate, Date checkDate) {
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.setTime(iniDate);
		fecha1.set(fecha1.get(Calendar.YEAR), fecha1.get(Calendar.MONTH), fecha1.getMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);
		fecha1.set(Calendar.MILLISECOND, 0);
		GregorianCalendar fecha2 = new GregorianCalendar();
		fecha2.setTime(endDate);
		fecha2.set(fecha2.get(Calendar.YEAR), fecha2.get(Calendar.MONTH), fecha2.getMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);
		fecha2.set(Calendar.MILLISECOND, 0);
		GregorianCalendar comparar = new GregorianCalendar();
		comparar.setTime(checkDate);
		comparar.set(comparar.get(Calendar.YEAR), comparar.get(Calendar.MONTH), comparar.getMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);
		comparar.set(Calendar.MILLISECOND, 0);

		if (fecha1.compareTo(comparar) <= 0 && fecha2.compareTo(comparar) >= 0)
			return true;
		else
			return false;

	}

	/**
	 * M�todo que retorna si la fecha1 es mayor que la fecha2.
	 * 
	 * @author osmany.ce
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public static boolean compararFechas(Date fecha1, Date fecha2) {
		if (fecha1 != null && fecha2 != null && fecha1.getTime() > fecha2.getTime()) {
			return true;
		}
		return false;
	}

	/**
	 * M�todo que retorna la cantidad de a�os entre dos fechas. El orden de las
	 * fechas no importa.
	 * 
	 * @author osmany.ce 07/05/2015
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public static Integer calcularAnnos(Date fecha1, Date fecha2) {
		if (fecha1 == null || fecha2 == null) {
			return Integer.valueOf(0);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha1);
		int anno1 = calendar.get(Calendar.YEAR);
		calendar.setTime(fecha2);
		int anno2 = calendar.get(Calendar.YEAR);
		return Math.abs(anno1 - anno2);
	}

	/**
	 * M�todo que retorna la cantidad de d�as que tiene un mes, dada una fecha
	 * como par�metro.
	 * 
	 * @author osmany.ce 02/10/2015
	 * @param fecha
	 * @return
	 */
	public static int cantidadDiasMes(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * M�todo que retorna fecha con la cantidad de d�as que se pasan como
	 * par�metro sumados o restados.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @param fecha
	 * @param dias
	 * @param restar
	 * @return
	 */
	public static Date sumarRestarDiasFecha(Date fecha, int dias, boolean restar) { // NOPMD
																					// by
																					// rene.travez
																					// on
																					// 17/09/15
																					// 10:07
																					// AM
		if (restar) {
			dias *= -1;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de d�as a a�adir, o
													// restar en caso de
													// d�as < 0
		return calendar.getTime();
	}

	/**
	 * M�todo que retorna fecha con la cantidad de d�as que se pasan como
	 * par�metro sumados o restados.
	 * 
	 * @author amaldonado 03/06/2015
	 * @param fecha
	 * @param mes
	 * @param restar
	 * @return
	 */
	public static Date sumarRestarMesesFecha(Date fecha, int meses, boolean restar) {
		if (restar) {
			meses *= -1;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MONTH, meses); // numero de meses a a�adir, o
												// restar en caso de meses
												// < 0
		return calendar.getTime();
	}

	/**
	 * M�todo que retorna fecha con la cantidad de d�as que se pasan como
	 * par�metro sumados o restados.
	 * 
	 * @author amaldonado 03/06/2015
	 * @param fecha
	 * @param mes
	 * @param restar
	 * @return
	 */
	public static Date sumarRestarAnnosFecha(Date fecha, int annos, boolean restar) {
		if (restar) {
			annos *= -1;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.YEAR, annos); // numero de meses a a�adir, o
											// restar en caso de annos <
											// 0
		return calendar.getTime();
	}

	/**
	 * M�todo que retorna la fecha en el primer d�a del mes, de la fecha pasada
	 * como par�metro.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @param fecha
	 * @return
	 */
	public static Date getPrimerDiaDelMes(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, cal.getMinimum(Calendar.HOUR_OF_DAY), cal.getMinimum(Calendar.MINUTE), cal.getMinimum(Calendar.SECOND));
		return cal.getTime();
	}

	/**
	 * M�todo que retorna un n�mero en texto, formado por la hora actual.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @return
	 */
	public static String getHoraMinSec() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY) + "" + cal.get(Calendar.MINUTE) + "" + cal.get(Calendar.SECOND) + "" + cal.get(Calendar.MILLISECOND);
	}

	/**
	 * M�todo que retorna la fecha en el �ltimo d�a del mes, de la fecha pasada
	 * como par�metro.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @param fecha
	 * @return
	 */
	public static Date getUltimoDiaDelMes(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH), cal.getMinimum(Calendar.HOUR_OF_DAY), cal.getMinimum(Calendar.MINUTE), cal.getMinimum(Calendar.SECOND));
		return cal.getTime();
	}
	

	/**
	 * M�todo que retorna el a�o actual.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @return
	 */
	public static Integer getAnnoActual() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.YEAR);
	}

	/**
	 * M�todo que retorna el a�o de una fecha pasada como par�metro.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @param fecha
	 * @return
	 */
	public static Integer getAnnoFecha(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * M�todo que retorna el mes de una fecha pasada como par�metro. El primer
	 * mes del calendario (enero) es el valor 0
	 * 
	 * @author osmany.ce 08/09/2015
	 * @param fecha
	 * @return
	 */
	public static Integer getMesFecha(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * M�todo que retorna la cantidad de d�as que faltan de un mes, dada una
	 * fecha como par�metro.
	 * 
	 * @author osmany.ce 13/08/2015
	 * @param fecha
	 * @return
	 */
	public static long getCantDiasRestantesMes(Date fecha) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(fecha);
		cal2.setTime(getUltimoDiaDelMes(fecha));

		return difDias(cal1.getTime(), cal2.getTime());
	}

	/**
	 * M�todo que retorna la cantidad de d�as que han pasado de un mes, dada una
	 * fecha como par�metro.
	 * 
	 * @author osmany.ce 02/06/2015
	 * @param fecha
	 * @return
	 */
	public static long getCantDiaspasadosMes(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		return cal.get(Calendar.DAY_OF_MONTH);
		/*
		 * Calendar cal1 = Calendar.getInstance(); Calendar cal2 =
		 * Calendar.getInstance(); cal1.setTime(fecha); cal2.setTime(fecha);
		 * cal1.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), 0, 0, 0,
		 * 0); cal2.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH),
		 * cal2.getActualMaximum(Calendar.DAY_OF_MONTH), 0,0,0); return
		 * difDias(cal1.getTime(), cal2.getTime());
		 */
	}

	/**
	 * M�todo que retorna dada una fecha como par�metro, si el d�a es menor que
	 * el otro n�mero pasado como par�metro.
	 * 
	 * @author osmany.ce 11/08/2015
	 * @param boolean
	 * @return
	 */
	public static boolean esDiaMenor(Date fecha, int numero) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		if (cal.get(Calendar.DAY_OF_MONTH) <= numero)
			return true;
		return false;
	}

	/**
	 * M�todo para copiar uana fecha pasada como par�metro.
	 * 
	 * @author osmany.ce 03/07/2015
	 * @param fecha
	 * @return Date
	 */
	public static Date copiarFecha(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		return calendar.getTime();
	}

	/**
	 * M�todo que retorna la fecha pasada como par�metro sin la hora.
	 * 
	 * @author osmany.ce 29/05/2015
	 * @param fecha
	 * @return
	 */
	public static Date getFechaSinHora(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cal.getTime();
	}

	public static Date strToDate(String str, String regex) {
		SimpleDateFormat formatter = new SimpleDateFormat(regex);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			// System.out.println("DateUtil.strToDate()");
			LOG.error("strToDate() {}", e);
		}
		return null;
	}

	/**
	 * M�todo que retorna la cantidad de meses, dias, horas, minutos, segundos.
	 * Cuando la fechaFin es el mes de febrero no lo cuenta como un mes
	 */
	@SuppressWarnings("static-access")
	public static String calcularCantidadMeses(Date fechaIni, Date fechaFin) {

		java.util.GregorianCalendar jCal = new java.util.GregorianCalendar();
		java.util.GregorianCalendar jCal2 = new java.util.GregorianCalendar();
		jCal.setTime(fechaIni);
		jCal2.setTime(fechaFin);

		long diferencia = jCal2.getTime().getTime() - jCal.getTime().getTime();
		double minutos = diferencia / (1000 * 60);
		long horas = (long) (minutos / 60);
		long minuto = (long) (minutos % 60);
		long segundos = diferencia % 1000;
		long dias = horas / 24;
		// Calcular meses...
		// Crear vector para almacenar los diferentes dias maximos segun
		// correponda
		String[] mesesAnio = new String[12];
		mesesAnio[0] = "31";
		// validacion de los a�os bisiestos
		if (jCal.isLeapYear(jCal.YEAR)) {
			mesesAnio[1] = "29";
		} else {
			mesesAnio[1] = "28";
		}
		mesesAnio[2] = "31";
		mesesAnio[3] = "30";
		mesesAnio[4] = "31";
		mesesAnio[5] = "30";
		mesesAnio[6] = "31";
		mesesAnio[7] = "31";
		mesesAnio[8] = "30";
		mesesAnio[9] = "31";
		mesesAnio[10] = "30";
		mesesAnio[11] = "31";
		int diasRestantes = (int) dias;
		// variable almacenar� el total de meses que hay en esos dias
		int totalMeses = 0;
		int mesActual = jCal.MONTH;
		// Restar los dias de cada mes desde la fecha de ingreso hasta que ya no
		// queden sufcientes
		// dias para
		// completar un mes.
		for (int i = 0; i <= 11; i++) {
			// Validar a�o, si sumando 1 al mes actual supera el fin de a�o,
			// setea la variable a principio de a�o
			if ((mesActual + 1) >= 12) {
				mesActual = i;
			}
			// Validar que el numero de dias resultantes de la resta de las 2
			// fechas, menos los dias
			// del mes correspondiente sea mayor a cero, de ser asi totalMeses
			// aumenta,continuar
			// hasta
			// que ya nos se cumpla.
			if ((diasRestantes - Integer.parseInt(mesesAnio[mesActual])) >= 0) {
				totalMeses++;
				diasRestantes = diasRestantes - Integer.parseInt(mesesAnio[mesActual]);
				mesActual++;
			} else {
				break;
			}
		}
		// Resto de horas despues de sacar los dias
		horas = horas % 24;
		String salida = "";
		if (totalMeses > 0) {
			if (totalMeses > 1)
				salida = salida + String.valueOf(totalMeses) + " Meses,  ";
			else
				salida = salida + String.valueOf(totalMeses) + " Mes, ";
		}
		if (diasRestantes > 0) {
			if (diasRestantes > 1)
				salida = salida + String.valueOf(diasRestantes) + " Dias, ";
			else
				salida = salida + String.valueOf(diasRestantes) + " Dia, ";
		}

		salida = salida + String.valueOf(horas) + ":" + String.valueOf(minuto) + ":" + String.valueOf(segundos) + ".";
		return salida;
	}

	/**
	 * <b> Metodo para validar que la fecha de inicio no debe ser mayor que la
	 * fecha de finalizacion. </b>
	 * <p>
	 * [Author rene.travez, 02/12/2015]
	 * </p>
	 * 
	 * @param fechaInicio
	 *            La fecha Inicio.
	 * @param fechaFin
	 *            La fecha Fin.
	 * @return Returno 1.
	 * @throws ParseException
	 *             Si existe un error.
	 */
	public static Integer validarFechas(Date fechaInicio, Date fechaFin) throws ParseException {
		Integer resultado = 0;
		if (fechaFin.getTime() < fechaInicio.getTime()) {
			resultado = 1;
		}
		return resultado;
	}

	private static long getDifDate(Date date1, Date date2) {
		return Math.abs(date1.getTime() - date2.getTime());
	}

	public static long difSegundos(Date date1, Date date2) {
		return getDifDate(date1, date2) / SEGUNDOS;
	}

	public static long difMinutos(Date date1, Date date2) {
		return getDifDate(date1, date2) / MINUTOS;
	}

	public static long difHoras(Date date1, Date date2) {
		return getDifDate(date1, date2) / HORAS;
	}

	public static long difDias(Date date1, Date date2) {
		return getDifDate(date1, date2) / DIAS;
	}

	public static long difSemanas(Date date1, Date date2) {
		return getDifDate(date1, date2) / SEMANAS;
	}

	public static long difMeses(Date date1, Date date2) {
		return getDifDate(date1, date2) / MESES;
	}

	public static long difAnnos(Date date1, Date date2) {
		return getDifDate(date1, date2) / ANNOS;
	}

	public static TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * Permite convertir un String en fecha (Date).
	 * 
	 * @param fecha
	 *            (String) la fecha a la cual deseo convertir
	 * @return Date la fecha en formato Date
	 * @author rtravez
	 */
	public static Date aplicarFromato(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = fecha;
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(strFecha);
			return fechaDate;
		} catch (ParseException ex) {
			return fechaDate;
		}
	}
	
	public static Date aplicarFromatoFechaDate(String fecha, String format) {
		SimpleDateFormat formato = new SimpleDateFormat(format);
		String strFecha = fecha;
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(strFecha);
			return fechaDate;
		} catch (ParseException ex) {
			return fechaDate;
		}
	}
	
	

	public static String getNombre(Integer month) {
		String result = "";
		switch (month) {
		case 0: {
			result = "Enero";
			break;
		}
		case 1: {
			result = "Febrero";
			break;
		}
		case 2: {
			result = "Marzo";
			break;
		}
		case 3: {
			result = "Abril";
			break;
		}
		case 4: {
			result = "Mayo";
			break;
		}
		case 5: {
			result = "Junio";
			break;
		}
		case 6: {
			result = "Julio";
			break;
		}
		case 7: {
			result = "Agosto";
			break;
		}
		case 8: {
			result = "Septiembre";
			break;
		}
		case 9: {
			result = "Octubre";
			break;
		}
		case 10: {
			result = "Noviembre";
			break;
		}
		case 11: {
			result = "Diciembre";
			break;
		}
		default: {
			result = "Error";
			break;
		}
		}
		return result;
	}
}
