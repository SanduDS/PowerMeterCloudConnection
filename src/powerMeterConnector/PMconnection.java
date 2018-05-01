/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerMeterConnector;

import com.invertor.modbus.ModbusMaster;
import com.invertor.modbus.ModbusMasterFactory;
import com.invertor.modbus.serial.SerialParameters;
import com.invertor.modbus.serial.SerialPort;
import jssc.SerialPortList;

/**
 *
 * @author Danushka
 */
public class PMconnection {
    private static PMconnection plc;
    private ModbusMaster master;
    
    public PMconnection(){
         SerialParameters sp = new SerialParameters();
        //Modbus.setLogLevel(Modbus.LogLevel.LEVEL_DEBUG); reading response
       try {
            String[] port_list = null;
            if(port_list==null){
            
                port_list=new SerialPortList().getPortNames();
            }
            if (port_list.length > 0) {
              //  System.out.println("Port: "+port_list[0]);
                //set the compatible parameters for the PLC
                sp.setDevice(port_list[0]);
                sp.setBaudRate(SerialPort.BaudRate.BAUD_RATE_9600);
                sp.setDataBits(8);
                sp.setParity(SerialPort.Parity.EVEN);
                sp.setStopBits(1);
                //if(master==null){ //singleton (not the correct)
                    master = ModbusMasterFactory.createModbusMasterRTU(sp);
               // }
                
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
    
    }
    public static PMconnection getInstance(){
        if(plc==null){
            plc=new PMconnection();
        }
        return plc;
    }
    public ModbusMaster getMaster(){
        return master;
    
    }
  
}
