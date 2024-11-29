import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class TelaUsuario extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final ProcessoGeral process = new ProcessoGeral();
    private File arquivo;

    public TelaUsuario() {
        initComponents();
        update();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jAbrir = new javax.swing.JFileChooser();
        jSalvar = new javax.swing.JFileChooser();
        jPanel4 = new javax.swing.JPanel();
        painelLocal = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        varDOIS = new javax.swing.JTextField();
        varTRES = new javax.swing.JTextField();
        btLocal = new javax.swing.JButton();
        painelGeral = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        varUM = new javax.swing.JTextField();
        btGeral = new javax.swing.JButton();
        painelDados = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        informa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btAbrir = new javax.swing.JButton();
        painelTela = new javax.swing.JPanel();
        textoTela = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        corLegenda = new javax.swing.JLabel();
        cd1 = new javax.swing.JLabel();
        cd2 = new javax.swing.JLabel();
        cd3 = new javax.swing.JLabel();
        cd4 = new javax.swing.JLabel();
        cd5 = new javax.swing.JLabel();
        cd6 = new javax.swing.JLabel();

        jAbrir.setAcceptAllFileFilterUsed(false);
        jSalvar.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(923, 667));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(913, 661));
        jPanel4.setLayout(null);

        painelLocal.setBackground(new java.awt.Color(255, 255, 255));
        painelLocal.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "LOCAL FILTERING",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Bodoni MT", 0, 12), new java.awt.Color(0, 51, 102)));
        painelLocal.setEnabled(false);
        painelLocal.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalTextPosition(javax.swing.JTextField.RIGHT);
        jLabel5.setText("Variation of limits (%):");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painelLocal,
                org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel5,
                org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        painelLocal.add(jLabel5);
        jLabel5.setBounds(10, 57, 138, 17);

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalTextPosition(javax.swing.JTextField.RIGHT);
        jLabel6.setText("Spacial dependence (m):");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painelLocal,
                org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel6,
                org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        painelLocal.add(jLabel6);
        jLabel6.setBounds(5, 28, 143, 17);

        varDOIS.setFont(new java.awt.Font("Bodoni MT", 1, 14));
        varDOIS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        varDOIS.setText("200");
        varDOIS.setPreferredSize(new java.awt.Dimension(51, 22));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painelLocal,
                org.jdesktop.beansbinding.ELProperty.create("${enabled}"), varDOIS,
                org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        painelLocal.add(varDOIS);
        varDOIS.setBounds(152, 25, 51, 23);

        varTRES.setFont(new java.awt.Font("Bodoni MT", 1, 14));
        varTRES.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        varTRES.setText("25");
        varTRES.setPreferredSize(new java.awt.Dimension(51, 22));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painelLocal,
                org.jdesktop.beansbinding.ELProperty.create("${enabled}"), varTRES,
                org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        painelLocal.add(varTRES);
        varTRES.setBounds(152, 54, 51, 22);

        btLocal.setBackground(new java.awt.Color(255, 255, 255));
        btLocal.setForeground(new java.awt.Color(255, 255, 255));
        btLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
        btLocal.setBorderPainted(false);
        btLocal.setContentAreaFilled(false);
        btLocal.addActionListener((java.awt.event.ActionEvent evt) -> btLocalActionPerformed(evt));
        painelLocal.add(btLocal);
        btLocal.setBounds(240, 40, 40, 30);

        jPanel4.add(painelLocal);
        painelLocal.setBounds(0, 180, 290, 88);

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "GENERAL FILTERING",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Bodoni MT", 0, 12), new java.awt.Color(0, 51, 102)));
        painelGeral.setEnabled(false);
        painelGeral.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalTextPosition(javax.swing.JTextField.LEFT);
        jLabel3.setText("Variation of limit (%):");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painelGeral,
                org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel3,
                org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        painelGeral.add(jLabel3);
        jLabel3.setBounds(9, 27, 133, 17);

        varUM.setFont(new java.awt.Font("Bodoni MT", 1, 14));
        varUM.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        varUM.setText("50.0");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, painelGeral,
                org.jdesktop.beansbinding.ELProperty.create("${enabled}"), varUM,
                org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        painelGeral.add(varUM);
        varUM.setBounds(150, 23, 50, 23);

        btGeral.setBackground(new java.awt.Color(255, 255, 255));
        btGeral.setForeground(new java.awt.Color(255, 255, 255));
        btGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
        btGeral.setBorderPainted(false);
        btGeral.setContentAreaFilled(false);
        btGeral.addActionListener((java.awt.event.ActionEvent evt) -> btGeralActionPerformed(evt));
        painelGeral.add(btGeral);
        btGeral.setBounds(240, 20, 40, 30);

        jPanel4.add(painelGeral);
        painelGeral.setBounds(0, 120, 290, 59);

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "DATA",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Bodoni MT", 0, 12), new java.awt.Color(0, 51, 102)));
        painelDados.setPreferredSize(new java.awt.Dimension(290, 290));
        painelDados.setVisible(false);
        painelDados.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 0, 13));
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("ORIGINAL");
        painelDados.add(jLabel14);
        jLabel14.setBounds(122, 17, 67, 16);

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 0, 13));
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("FILTERED");
        painelDados.add(jLabel15);
        jLabel15.setBounds(217, 17, 68, 16);

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Number of points :");
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelDados.add(jLabel16);
        jLabel16.setBounds(5, 39, 111, 17);

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Minimum value    :");
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelDados.add(jLabel17);
        jLabel17.setBounds(5, 62, 110, 17);

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Maximum value   :");
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelDados.add(jLabel18);
        jLabel18.setBounds(5, 85, 109, 17);

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Average value      :");
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelDados.add(jLabel19);
        jLabel19.setBounds(5, 108, 107, 17);

        jLabel20.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Std. deviation        :");
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelDados.add(jLabel20);
        jLabel20.setBounds(5, 131, 108, 17);

        jLabel21.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("C. V. (%)                  :");
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelDados.add(jLabel21);
        jLabel21.setBounds(5, 154, 107, 17);

        jLabel22.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel22);
        jLabel22.setBounds(122, 39, 70, 17);

        jLabel23.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel23);
        jLabel23.setBounds(122, 62, 70, 17);

        jLabel24.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel24);
        jLabel24.setBounds(122, 85, 70, 17);

        jLabel25.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel25);
        jLabel25.setBounds(122, 108, 70, 17);

        jLabel26.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel26);
        jLabel26.setBounds(122, 131, 70, 17);

        jLabel27.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel27);
        jLabel27.setBounds(122, 154, 70, 17);

        jLabel28.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel28);
        jLabel28.setBounds(217, 39, 65, 17);

        jLabel29.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel29);
        jLabel29.setBounds(217, 62, 65, 17);

        jLabel30.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel30);
        jLabel30.setBounds(217, 85, 65, 17);

        jLabel31.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel31);
        jLabel31.setBounds(217, 108, 65, 17);

        jLabel32.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel32);
        jLabel32.setBounds(217, 131, 65, 17);

        jLabel33.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        painelDados.add(jLabel33);
        jLabel33.setBounds(217, 154, 65, 17);

        informa.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        informa.setForeground(new java.awt.Color(255, 0, 0));
        painelDados.add(informa);
        informa.setBounds(10, 260, 150, 20);

        jPanel4.add(painelDados);
        painelDados.setBounds(0, 380, 290, 287);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "FILE",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Bodoni MT", 0, 12), new java.awt.Color(0, 51, 102)));
        jPanel1.setLayout(null);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/disquete32.png")));
        btSalvar.setAlignmentY(0.4F);
        btSalvar.setVisible(false);
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaosalvar();
            }
        });
        jPanel1.add(btSalvar);
        btSalvar.setBounds(250, 10, 30, 40);

        jLabel34.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel34);
        jLabel34.setBounds(50, 30, 100, 17);

        btAbrir.setBackground(new java.awt.Color(255, 255, 255));
        btAbrir.setForeground(new java.awt.Color(255, 255, 255));
        btAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasta32.png")));
        btAbrir.setBorderPainted(false);
        btAbrir.setContentAreaFilled(false);
        btAbrir.setFocusPainted(false);
        btAbrir.setFocusable(false);
        btAbrir.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btAbrir.addActionListener((java.awt.event.ActionEvent evt) -> btAbrirActionPerformed(evt));
        jPanel1.add(btAbrir);
        btAbrir.setBounds(10, 20, 40, 30);

        jPanel4.add(jPanel1);
        jPanel1.setBounds(0, 60, 290, 56);

        painelTela.setBackground(new java.awt.Color(255, 255, 255));
        painelTela.setAutoscrolls(true);
        painelTela.setPreferredSize(new java.awt.Dimension(0, 0));
        painelTela.setLayout(null);

        textoTela.setBackground(new java.awt.Color(255, 255, 255));
        textoTela.setForeground(new java.awt.Color(255, 255, 255));
        textoTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/infoINICIAL.png")));
        textoTela.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        painelTela.add(textoTela);
        textoTela.setBounds(10, 0, 610, 560);

        jPanel4.add(painelTela);
        painelTela.setBounds(290, 70, 630, 560);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MAPFILTRO.png")));
        jPanel4.add(jLabel12);
        jLabel12.setBounds(0, 0, 927, 60);

        corLegenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escala.png")));
        jPanel4.add(corLegenda);
        corLegenda.setBounds(450, 630, 280, 13);

        cd1.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        cd1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(cd1);
        cd1.setBounds(450, 645, 42, 15);

        cd2.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        cd2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(cd2);
        cd2.setBounds(493, 645, 42, 15);

        cd3.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        cd3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(cd3);
        cd3.setBounds(538, 645, 42, 15);

        cd4.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        cd4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(cd4);
        cd4.setBounds(586, 645, 42, 15);

        cd5.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        cd5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(cd5);
        cd5.setBounds(628, 645, 42, 15);

        cd6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        cd6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(cd6);
        cd6.setBounds(672, 645, 42, 15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE));

        bindingGroup.bind();

        pack();
    }

    public void botaoabrir() {
        update();
        textoTela.setVisible(false);
        arqfilter(jAbrir);
        int ab = jAbrir.showOpenDialog(null);
        if (ab == JFileChooser.APPROVE_OPTION) {
            try {
                arquivo = jAbrir.getSelectedFile();
                process.process1(arquivo);
                jLabel34.setText(jAbrir.getName(arquivo));
                legenda1(process.estat);
                painelGeral.setEnabled(true);
                btGeral.setVisible(true);
                process.displayData(painelTela, process.dataOriginal);
                legenda3(process.mapLeg);
                update2();
                painelGeral.setVisible(true);
                painelDados.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void botaosalvar() {
        arqfilter(jSalvar);
        int janela = jSalvar.showSaveDialog(null);
        if (janela == JFileChooser.APPROVE_OPTION) {
            File arquivoSalvar = jSalvar.getSelectedFile();
            String index = jSalvar.getFileFilter().getDescription();
            int ext;
            if ("Text File (*.txt)".equals(index)) {
                ext = 2;
                process.salvardados(arquivoSalvar, ext);
            } else if ("Comma Separated Values (*.csv)".equals(index)) {
                ext = 1;
                process.salvardados(arquivoSalvar, ext);
            }
        }
    }

    public void botaofiltrogeral() {
        textoTela.setVisible(false);
        double var = parseDoubleOrZero(varUM.getText().trim());
        process.filtrogeral(var);
        legenda2(process.estat);
        painelLocal.setEnabled(true);
        btAbrir.setVisible(true);
        btLocal.setVisible(true);
        process.displayData(painelTela, process.dataFiltered);
        legenda3(process.mapLeg);
        update2();
    }

    public void botaofiltrolocal() {
        textoTela.setVisible(false);
        double raio = parseDoubleOrZero(varDOIS.getText().trim());
        double var = parseDoubleOrZero(varTRES.getText().trim());
        process.filtrolocal(var, raio);
        legenda2(process.estat);
        process.displayData(painelTela, process.dataClean);
        legenda3(process.mapLeg);
        update2();
        btSalvar.setVisible(true);
    }

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        informa.setText("Opening file...");
        botaoabrir();
        Timer timer = new Timer(50, (ActionEvent evt1) -> informa.setText(" "));
        timer.setRepeats(false);
        timer.start();
    }

    private void btGeralActionPerformed(java.awt.event.ActionEvent evt) {
        informa.setText("Processing...");
        new Thread(() -> {
            botaofiltrogeral();
            informa.setText(" ");
        }).start();
    }

    private void btLocalActionPerformed(java.awt.event.ActionEvent evt) {
        informa.setText("Processing...");
        new Thread(() -> {
            botaofiltrolocal();
            informa.setText(" ");
        }).start();
    }

    private void arqfilter(JFileChooser x) {
        x.resetChoosableFileFilters();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values (*.csv)", "csv");
        x.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Text File (*.txt)", "txt");
        x.addChoosableFileFilter(filter);
    }

    private void legenda1(double[] stat) {
        jLabel22.setText(String.format("%.0f", stat[0]));
        jLabel23.setText(String.format("%.1f", stat[1]));
        jLabel24.setText(String.format("%.1f", stat[2]));
        jLabel25.setText(String.format("%.1f", stat[3]));
        jLabel26.setText(String.format("%.1f", stat[4]));
        jLabel27.setText(String.format("%.1f", stat[5]));
    }

    private void legenda2(double[] stat) {
        jLabel28.setText(String.format("%.0f", stat[0]));
        jLabel29.setText(String.format("%.1f", stat[1]));
        jLabel30.setText(String.format("%.1f", stat[2]));
        jLabel31.setText(String.format("%.1f", stat[3]));
        jLabel32.setText(String.format("%.1f", stat[4]));
        jLabel33.setText(String.format("%.1f", stat[5]));
    }

    private void legenda3(double[] quartis) {
        corLegenda.setVisible(true);
        cd1.setText(String.format("%.1f", quartis[0]));
        cd2.setText(String.format("%.1f", quartis[1]));
        cd3.setText(String.format("%.1f", quartis[2]));
        cd4.setText(String.format("%.1f", quartis[3]));
        cd5.setText(String.format("%.1f", quartis[4]));
        cd6.setText(String.format("%.1f", quartis[5]));
    }

    private void update() {
        btSalvar.setVisible(false);
        btGeral.setVisible(false);
        btLocal.setVisible(false);
        jLabel28.setText(" ");
        jLabel29.setText(" ");
        jLabel30.setText(" ");
        jLabel31.setText(" ");
        jLabel32.setText(" ");
        jLabel33.setText(" ");
        cd1.setText(" ");
        cd2.setText(" ");
        cd3.setText(" ");
        cd4.setText(" ");
        cd5.setText(" ");
        cd6.setText(" ");
        corLegenda.setVisible(false);
    }

    private void update2() {
        corLegenda.setVisible(true);
        cd1.setVisible(true);
        cd2.setVisible(true);
        cd3.setVisible(true);
        cd4.setVisible(true);
        cd5.setVisible(true);
        cd6.setVisible(true);
    }

    private double parseDoubleOrZero(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btGeral;
    private javax.swing.JButton btLocal;
    private javax.swing.JLabel btSalvar;
    private javax.swing.JLabel cd1;
    private javax.swing.JLabel cd2;
    private javax.swing.JLabel cd3;
    private javax.swing.JLabel cd4;
    private javax.swing.JLabel cd5;
    private javax.swing.JLabel cd6;
    private javax.swing.JLabel corLegenda;
    private javax.swing.JLabel informa;
    private javax.swing.JFileChooser jAbrir;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JFileChooser jSalvar;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelLocal;
    private javax.swing.JPanel painelTela;
    private javax.swing.JLabel textoTela;
    private javax.swing.JTextField varDOIS;
    private javax.swing.JTextField varTRES;
    private javax.swing.JTextField varUM;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration
}
