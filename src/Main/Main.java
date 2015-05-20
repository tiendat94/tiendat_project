/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author HoangDuoc
 */
public class Main extends javax.swing.JFrame {

    Search search;

    public Main() {
        initComponents();
        this.setLocation(70, 10);
        init();
    }

    public void init() {
        Home home = new Home();
        home.setVisible(true);
        this.Desktop.add(home);

    }

    public JMenu getMnDocgia() {
        return mnDocgia;
    }

    public void setMnDocgia(JMenu mnDocgia) {
        this.mnDocgia = mnDocgia;
    }

    public JMenu getMnQlsach() {
        return mnQlsach;
    }

    public void setMnQlsach(JMenu mnQlsach) {
        this.mnQlsach = mnQlsach;
    }

    public JMenu getMnThongke() {
        return mnThongke;
    }

    public void setMnThongke(JMenu mnThongke) {
        this.mnThongke = mnThongke;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        mnDanhmuc = new javax.swing.JMenu();
        miTacgia = new javax.swing.JMenuItem();
        miNhaxuatban = new javax.swing.JMenuItem();
        miNgonngu = new javax.swing.JMenuItem();
        mnDocgia = new javax.swing.JMenu();
        miDocgia = new javax.swing.JMenuItem();
        mnQlsach = new javax.swing.JMenu();
        miThemsach = new javax.swing.JMenuItem();
        miXoasach = new javax.swing.JMenuItem();
        mnMuontra = new javax.swing.JMenu();
        miMuonsach = new javax.swing.JMenuItem();
        miTrasach = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnThongke = new javax.swing.JMenu();
        miThongke = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lí thư viên Tạ Quang Bửu ");
        setResizable(false);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1233, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/29_House_48x48.png"))); // NOI18N
        jMenu7.setText("Trang chủ");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        mnDanhmuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FML.png"))); // NOI18N
        mnDanhmuc.setText("Danh mục");
        mnDanhmuc.setEnabled(false);
        mnDanhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDanhmucActionPerformed(evt);
            }
        });

        miTacgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_business_32.png"))); // NOI18N
        miTacgia.setText("Tác giả");
        miTacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTacgiaActionPerformed(evt);
            }
        });
        mnDanhmuc.add(miTacgia);

        miNhaxuatban.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/29_House_32x32.png"))); // NOI18N
        miNhaxuatban.setText("Nhà xuất bản");
        miNhaxuatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNhaxuatbanActionPerformed(evt);
            }
        });
        mnDanhmuc.add(miNhaxuatban);

        miNgonngu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Letters32.png"))); // NOI18N
        miNgonngu.setText("Ngôn ngữ");
        miNgonngu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNgonnguActionPerformed(evt);
            }
        });
        mnDanhmuc.add(miNgonngu);

        jMenuBar1.add(mnDanhmuc);

        mnDocgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Graduate-male64.png"))); // NOI18N
        mnDocgia.setText("Độc giả");
        mnDocgia.setEnabled(false);

        miDocgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/users_32.png"))); // NOI18N
        miDocgia.setText("Quản lý độc giả");
        miDocgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDocgiaActionPerformed(evt);
            }
        });
        mnDocgia.add(miDocgia);

        jMenuBar1.add(mnDocgia);

        mnQlsach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Market-icon.png"))); // NOI18N
        mnQlsach.setText("QL Sách");
        mnQlsach.setEnabled(false);
        mnQlsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnQlsachActionPerformed(evt);
            }
        });

        miThemsach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book_add_32.png"))); // NOI18N
        miThemsach.setText("Thêm sách");
        miThemsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miThemsachActionPerformed(evt);
            }
        });
        mnQlsach.add(miThemsach);

        miXoasach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book_close_32.png"))); // NOI18N
        miXoasach.setText("Xóa sách");
        miXoasach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miXoasachActionPerformed(evt);
            }
        });
        mnQlsach.add(miXoasach);

        jMenuBar1.add(mnQlsach);

        mnMuontra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Test-paper64.png"))); // NOI18N
        mnMuontra.setText("Mượn trả");

        miMuonsach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basket_back_32.png"))); // NOI18N
        miMuonsach.setText("Mượn sách");
        miMuonsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMuonsachActionPerformed(evt);
            }
        });
        mnMuontra.add(miMuonsach);

        miTrasach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basket_go_32.png"))); // NOI18N
        miTrasach.setText("Trả sách");
        miTrasach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTrasachActionPerformed(evt);
            }
        });
        mnMuontra.add(miTrasach);

        jMenuBar1.add(mnMuontra);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search_64x64.png"))); // NOI18N
        jMenu5.setText("Tra cứu");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        mnThongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Stocks.png"))); // NOI18N
        mnThongke.setText("Thống kê");
        mnThongke.setEnabled(false);

        miThongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/page_blank_chart_32.png"))); // NOI18N
        miThongke.setText("Thống kê theo yêu cầu");
        miThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miThongkeActionPerformed(evt);
            }
        });
        mnThongke.add(miThongke);

        jMenuBar1.add(mnThongke);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/14_Delete_48x48.png"))); // NOI18N
        jMenu8.setText("Thoát");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu8ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miTacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTacgiaActionPerformed
        if ((JMenuItem) evt.getSource() == miTacgia) {
            this.Desktop.removeAll();
            Author tacgia = new Author();
            tacgia.setVisible(true);
            this.Desktop.add(tacgia);
    }//GEN-LAST:event_miTacgiaActionPerformed
    }
    private void miNhaxuatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNhaxuatbanActionPerformed
        if ((JMenuItem) evt.getSource() == miNhaxuatban) {
            this.Desktop.removeAll();
            Publisher nxb = new Publisher();
            nxb.setVisible(true);
            this.Desktop.add(nxb);
    }//GEN-LAST:event_miNhaxuatbanActionPerformed
    }
    private void jMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu8ActionPerformed

    }//GEN-LAST:event_jMenu8ActionPerformed

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát chương trình", "Thông báo", 2) == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        this.Desktop.removeAll();
        search = new Search();
        search.setVisible(true);
        this.Desktop.add(search);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        this.Desktop.removeAll();
        Home home = new Home();
        home.setVisible(true);
        this.Desktop.add(home);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void miThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miThongkeActionPerformed
        if ((JMenuItem) evt.getSource() == miThongke) {
            this.Desktop.removeAll();
            Thongke thongke = new Thongke();
            thongke.setVisible(true);
            this.Desktop.add(thongke);
        }
    }//GEN-LAST:event_miThongkeActionPerformed

    private void miDocgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDocgiaActionPerformed
        if ((JMenuItem) evt.getSource() == miDocgia) {
            this.Desktop.removeAll();
            ManagementUser user = new ManagementUser();
            user.setVisible(true);
            this.Desktop.add(user);
        }
    }//GEN-LAST:event_miDocgiaActionPerformed

    private void miNgonnguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNgonnguActionPerformed
        if ((JMenuItem) evt.getSource() == miNgonngu) {
            this.Desktop.removeAll();
            Language ngonngu = new Language();
            ngonngu.setVisible(true);
            this.Desktop.add(ngonngu);
        }
    }//GEN-LAST:event_miNgonnguActionPerformed

    private void mnDanhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDanhmucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDanhmucActionPerformed

    private void mnQlsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnQlsachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnQlsachActionPerformed

    private void miThemsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miThemsachActionPerformed
        if ((JMenuItem) evt.getSource() == miThemsach) {
            this.Desktop.removeAll();
            ThemSach ngonngu = new ThemSach();
            ngonngu.setVisible(true);
            this.Desktop.add(ngonngu);
    }//GEN-LAST:event_miThemsachActionPerformed
    }
    private void miXoasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miXoasachActionPerformed
        if ((JMenuItem) evt.getSource() == miXoasach) {
            this.Desktop.removeAll();
            XoaSach ngonngu = new XoaSach();
            ngonngu.setVisible(true);
            this.Desktop.add(ngonngu);
    }//GEN-LAST:event_miXoasachActionPerformed
    }
    private void miMuonsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMuonsachActionPerformed
        if ((JMenuItem) evt.getSource() == miMuonsach) {
            this.Desktop.removeAll();
            MuonSach ngonngu = new MuonSach(Login.manv);
            ngonngu.setVisible(true);
            this.Desktop.add(ngonngu);
        }
    }//GEN-LAST:event_miMuonsachActionPerformed

    private void miTrasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTrasachActionPerformed
        if ((JMenuItem) evt.getSource() == miTrasach) {
            this.Desktop.removeAll();
            TraSach ngonngu = new TraSach(Login.manv);
            ngonngu.setVisible(true);
            this.Desktop.add(ngonngu);
        }
    }//GEN-LAST:event_miTrasachActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Main().setVisible(true);
            }
        });
    }

    public JMenu getMnDanhmuc() {
        return mnDanhmuc;
    }

    public void setMnDanhmuc(JMenu mnDanhmuc) {
        this.mnDanhmuc = mnDanhmuc;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem miDocgia;
    private javax.swing.JMenuItem miMuonsach;
    private javax.swing.JMenuItem miNgonngu;
    private javax.swing.JMenuItem miNhaxuatban;
    private javax.swing.JMenuItem miTacgia;
    private javax.swing.JMenuItem miThemsach;
    private javax.swing.JMenuItem miThongke;
    private javax.swing.JMenuItem miTrasach;
    private javax.swing.JMenuItem miXoasach;
    private javax.swing.JMenu mnDanhmuc;
    private javax.swing.JMenu mnDocgia;
    private javax.swing.JMenu mnMuontra;
    private javax.swing.JMenu mnQlsach;
    private javax.swing.JMenu mnThongke;
    // End of variables declaration//GEN-END:variables
}
