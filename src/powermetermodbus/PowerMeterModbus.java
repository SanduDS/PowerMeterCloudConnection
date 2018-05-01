/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powermetermodbus;

import com.invertor.modbus.ModbusMaster;
import com.invertor.modbus.ModbusMasterFactory;
import com.invertor.modbus.exception.ModbusIOException;
import com.invertor.modbus.serial.SerialParameters;
import com.invertor.modbus.serial.SerialPort;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jssc.SerialPortList;


public class PowerMeterModbus {
      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CloudPowerMeterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CloudPowerMeterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CloudPowerMeterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CloudPowerMeterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
  try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            new CloudPowerMeterInterface().setVisible(true);
            
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null,"Theme Error");
        }
    }

    /* public static void main(String[] arg) {
        SerialParameters sp = new SerialParameters();
        //Modbus.setLogLevel(Modbus.LogLevel.LEVEL_DEBUG); reading response
       
        
        try {
            
            String[] port_list = SerialPortList.getPortNames();
            
            
            if (port_list.length > 0) {
                System.out.println("Port: "+port_list[0]);
                //set the compatible parameters for the PLC
                sp.setDevice(port_list[0]);
                sp.setBaudRate(SerialPort.BaudRate.BAUD_RATE_9600);
                sp.setDataBits(8);
                sp.setParity(SerialPort.Parity.EVEN);
                sp.setStopBits(1);
                
                ModbusMaster m = ModbusMasterFactory.createModbusMasterRTU(sp);
                m.connect();
                
                int slaveId = 1;
                int register =0;
                int quantity =14;
         
                try {
                    
                    for(int i =0; i<29;i++){
                       //m.writeSingleRegister(slaveId, i,1);
                    }
                    
                    
                   //m.writeSingleRegister(slaveId, 3, 28);
                   //m.writeSingleRegister(slaveId, 4001, 4001);
                    
                    int[] registerValues = m.readInputRegisters(slaveId, register, quantity);
                    //boolean[] coil=m.readCoils(slaveId, 1, quantity);
                    //System.out.println(""+coil[0]+"");
                    System.out.println("working");
                    // print values
                    for (int value : registerValues) {
                        String binNum=Integer.toBinaryString(value);
                        System.out.println("Address: " + register++ + ", Value: " + value+"-" +binNum);
                        
                    }
                    //float value = Float.intBitsToFloat((registerValues[1]<<16) | registerValues[0]);
                    //System.out.println(value);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Please Check the slave ID");
                } finally {
                    try {
                        m.disconnect();
                    } catch (ModbusIOException e1) {
                        e1.printStackTrace();
                        System.out.println("Error in Disconnect");
                    }
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
