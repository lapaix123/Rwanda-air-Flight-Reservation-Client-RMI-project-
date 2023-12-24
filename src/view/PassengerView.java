/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Booking;
import model.Country;
import model.Flight;
import model.Passenger;
import service.BookingService;
import service.CountryService;
import service.FlightService;

/**
 *
 * @author la paix
 */
public class PassengerView extends javax.swing.JFrame {

    /**
     * Creates new form PassengerView
     */
    public PassengerView() {
        initComponents();
        setLocationRelativeTo(null);
       
      
    }
    Long passengerId;
     public PassengerView(Long pasenger) {
        initComponents();
        passengerId=pasenger;
        setLocationRelativeTo(null);
        addToCombo();
        addFromCombo();
        addColumns();
        addrows();
        addColumn1();
        addrows1();
    }
     
    DefaultTableModel tbm = new DefaultTableModel();
 DefaultTableModel tbm1 = new DefaultTableModel();
    private void addColumns() {
        tbm.addColumn("#");
        tbm.addColumn("Number");
        tbm.addColumn("Arrival");
        tbm.addColumn("A Date");
        tbm.addColumn("Departure");
        tbm.addColumn("DP date");
        tbm.addColumn("Total seat");
        tbm.addColumn("Seat");
        tbm.addColumn("Price");
        tbm.addColumn("Airline");
        dataTable1.setModel(tbm);
    }

    private void addrows() {
        try {
            Registry rg = LocateRegistry.getRegistry("127.0.0.1", 6000);
            FlightService service = (FlightService) rg.lookup("flightService");
            List<Flight> flights = service.getAllFlights();
            for (Flight flight : flights) {
                tbm.addRow(new Object[]{
                    flight.getFlightId(),
                    flight.getFlightNumber(),
                    flight.getArrivalCity().getCountryName(),
                    flight.getArrivalDateTime(),
                    flight.getDepartureCity().getCountryName(),
                    flight.getDepartureDateTime(),
                    flight.getTotalSeats(),
                    flight.getAvailableSeats(),
                    flight.getBasePrice(),
                    flight.getAirline().getAirlineName()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addToCombo() {

        try {
            toCombo.removeAllItems();
            Registry rg = LocateRegistry.getRegistry("127.0.0.1", 6000);
            CountryService service = (CountryService) rg.lookup("countryService");
            List<Country> countrys = service.getAllCountries();

            if (countrys != null) {

                for (Country country : countrys) {
                    toCombo.addItem(country.getCountryId() + "-" + country.getCountryName());
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addFromCombo() {

        try {
            fromCombo.removeAllItems();
            Registry rg = LocateRegistry.getRegistry("127.0.0.1", 6000);
            CountryService service = (CountryService) rg.lookup("countryService");
            List<Country> countrys = service.getAllCountries();

            if (countrys != null) {

                for (Country country : countrys) {
                    fromCombo.addItem(country.getCountryId() + "-" + country.getCountryName());
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
     public void addColumn1() {
        tbm1.addColumn("#");
        tbm1.addColumn("Passenger");
        tbm1.addColumn("Flight Number");
        tbm1.addColumn("From ");
        tbm1.addColumn("To");
        tbm1.addColumn("booking Date");
        tbm1.addColumn("book No");
        tbm1.addColumn("status");
        dataTbl.setModel(tbm1);
    }

    public void addrows1() {
        try {
            Registry rg = LocateRegistry.getRegistry("127.0.0.1", 6000);

            BookingService service = (BookingService) rg.lookup("bookingService");
            Passenger passenger= new Passenger();
            passenger.setPassengerId(passengerId);
            List<Booking> bookings = service.findBookingsByPassenger(passenger);
            for (Booking booking : bookings) {
                tbm1.addRow(new Object[]{
                    booking.getBookingId(),
                    booking.getPassenger().getfNames() + "" + booking.getPassenger().getLnames(),
                    booking.getFlight().getFlightNumber(),
                    booking.getFlight().getArrivalCity(),
                    booking.getFlight().getDepartureCity(),
                    booking.getBookingaDAte(),
                    booking.getNumberOfbook(),
                    booking.getStatus()

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fromCombo = new javax.swing.JComboBox<>();
        toCombo = new javax.swing.JComboBox<>();
        depDate = new com.toedter.calendar.JDateChooser();
        returnDate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        numberTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/logorw.png"))); // NOI18N
        jLabel1.setText(" ");

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Passnger Booking Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(189, 189, 189)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dataTbl);

        dataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dataTable1);

        jLabel3.setText("From");

        jLabel4.setText("To");

        jLabel5.setText("Dispature Date ");

        jLabel6.setText("Return Date");

        fromCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        toCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Find Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fromCombo, 0, 205, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(toCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(depDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(returnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(depDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        numberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberTxtActionPerformed(evt);
            }
        });

        jLabel7.setText("Number Of Passenger");

        jButton2.setBackground(new java.awt.Color(19, 25, 121));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Book Now");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(38, 110, 4));
        jButton3.setText("Reset");

        jButton4.setBackground(new java.awt.Color(255, 204, 51));
        jButton4.setText("Cancel Book");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String countryInfo = fromCombo.getSelectedItem().toString();
        Long countryId = Long.parseLong(countryInfo.substring(0, countryInfo.indexOf("-")));

        String countryInfo1 = toCombo.getSelectedItem().toString();
        Long countryId1 = Long.parseLong(countryInfo1.substring(0, countryInfo1.indexOf("-")));

        Date dispDate = depDate.getDate();
        Date arrDate = returnDate.getDate();

//        try {
//
//            Registry rg = LocateRegistry.getRegistry("127.0.0.1", 6000);
//            FlightService service = (FlightService) rg.lookup("flightService");
//            List<Flight> found = service.searchFlights(countryId, countryId1, arrDate, dispDate);
//
//            if (found != null) {
//                tbm.setRowCount(0);
//                for (Flight flight : found) {
//                    tbm.addRow(new Object[]{
//                        flight.getFlightId(),
//                        flight.getFlightNumber(),
//                        flight.getArrivalCity().getCountryName(),
//                        flight.getArrivalDateTime(),
//                        flight.getDepartureCity().getCountryName(),
//                        flight.getDepartureDateTime(),
//                        flight.getTotalSeats(),
//                        flight.getAvailableSeats(),
//                        flight.getBasePrice(),
//                        flight.getAirline().getAirlineName()
//                    });
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(this, "Flight not found");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }


    }//GEN-LAST:event_jButton1ActionPerformed
    Long flightId;
    
    private void dataTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTable1MouseClicked
        int index = dataTable1.getSelectedRow();
        TableModel tbm = dataTable1.getModel();
        flightId = Long.parseLong(tbm.getValueAt(index, 0).toString());

    }//GEN-LAST:event_dataTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (numberTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plz passengure Number is required");
        } else if (flightId <= 0) {
            JOptionPane.showMessageDialog(this, "plz you have to select flight before booking");
        } else if (passengerId <= 0) {
            JOptionPane.showMessageDialog(this, "plz Passenger nedd Login");

        } else {
            try {

                Registry rg = LocateRegistry.getRegistry("127.0.0.1", 6000);
                BookingService service = (BookingService) rg.lookup("bookingService");

                Booking booking = new Booking();
                Flight flight = new Flight();
                flight.setFlightId(flightId);
                booking.setFlight(flight);
                booking.setNumberOfbook(Integer.parseInt(numberTxt.getText()));

                Passenger passenger = new Passenger();
                passenger.setPassengerId(passengerId);
                booking.setPassenger(passenger);
                booking.setBookingaDAte(new Date());
                booking.setStatus("pending");

                String message = service.createBooking(booking);
                if (message != null) {
                    JOptionPane.showMessageDialog(this, message);
                    tbm.setRowCount(0);
                    addrows();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PassengerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable1;
    private javax.swing.JTable dataTbl;
    private com.toedter.calendar.JDateChooser depDate;
    private javax.swing.JComboBox<String> fromCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField numberTxt;
    private com.toedter.calendar.JDateChooser returnDate;
    private javax.swing.JComboBox<String> toCombo;
    // End of variables declaration//GEN-END:variables
}
