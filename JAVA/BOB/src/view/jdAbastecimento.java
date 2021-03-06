/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.UsuarioControl;
import control.VeiculoCombustivelControl;
import control.VeiculoKMControl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import model.Auxiliar;
import model.Usuario;
import model.Veiculo;
import model.VeiculoCombustivel;

/**
 *
 * @author mario
 */
public class jdAbastecimento extends javax.swing.JDialog {

    Veiculo veiculo;
    Usuario usuario;
    ArrayList<VeiculoCombustivel> arraylist;
    jpCustoCombustivel jpRaiz;
    Auxiliar aux;
    VeiculoKMControl vkmCtrol;
    VeiculoCombustivelControl vcCtrol;
    
    public jdAbastecimento() {
        inicializar();
    }
    public jdAbastecimento(jpCustoCombustivel jpRaiz, Veiculo veiculo, Usuario usuario){
        super.setModal(true);
        inicializar();
        this.veiculo = veiculo;
        this.usuario = usuario;
        this.jpRaiz = jpRaiz;
        txfPlaca.setText(veiculo.getPlaca());
        txfUsuario.setText(usuario.getNome());
        txfKmAtual.setText(vkmCtrol.getUltimoKmByIDVeiculo(veiculo.getId())+"");
        txfCombustivel.setText(Veiculo.COMBUSTIVEIS[veiculo.getCombustivel()]);
        limparCampos();
    }
    private void inicializar(){
        initComponents();
        arraylist = new ArrayList<VeiculoCombustivel>();
        veiculo = new Veiculo();
        usuario = new Usuario();
        vkmCtrol = new VeiculoKMControl();
        vcCtrol = new VeiculoCombustivelControl();
        aux = new Auxiliar();
        
      // txfKmAtual = new JFormattedTextField(NumberFormat.getNumberInstance());
    }
    private void limparCampos(){
       // txfCombustivel.setText("");
        //txfPlaca.setText("");
        //txfUsuario.setText("");
        txfPosto.setText("");
        txfId.setText("0");
        txfLitragem.setText("");
        txfValor.setText("");
        txfKm.setText("");
        txfData.setText(aux.getDataStringAtual());
        preencherListViewDocumentos();
    }
    private void preencherSelectedListview(){
        try{
            int j = jList.getSelectedIndex();
            int i = arraylist.size()-j-1;   
            if(j>=0){
                btnSalvar.setText("Alterar");
                
                txfCombustivel.setText(arraylist.get(i).getCombustivel());
               // txfPlaca.setText(ve);
                txfUsuario.setText(new UsuarioControl().getNomeUsuarioById(arraylist.get(i).getIdUsuario()));
                txfPosto.setText(arraylist.get(i).getPosto());
                txfId.setText(arraylist.get(i).getId()+"");
                txfLitragem.setText(""+arraylist.get(i).getLitros());
                //txfValor.setText(aux.StringFloatReais(arraylist.get(i).getValor()));
                txfValor.setText(arraylist.get(i).getValor()+"");
                txfKm.setText(""+arraylist.get(i).getKm());
                txfData.setText(aux.getDataString(arraylist.get(i).getDataMilis()));    
            }
        }catch(Exception e){
            
        }
    }
    
    private void preencherListViewDocumentos(){
        DefaultListModel listModel = new DefaultListModel();
        int j=0;
        arraylist = new VeiculoCombustivelControl().getArrayListByIDVeiculo(veiculo.getId());
        UsuarioControl uc = new UsuarioControl();
        for(int i=arraylist.size()-1; i>=0; i--){
            String linha = "Nº " + (i+1);
            linha = linha + " - DATA: " + aux.getDataString(arraylist.get(i).getDataMilis());
            linha = linha +", Usuario/Motorista: " + uc.getNomeUsuarioById(arraylist.get(i).getIdUsuario());
            linha = linha +", KM: " + arraylist.get(i).getKm();
            listModel.add(j,linha);
            j++;
        }
        jList.setModel(listModel);
    }
   
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfPosto = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txfPlaca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfData = new javax.swing.JTextField();
        try{            
            javax.swing.text.MaskFormatter data =
            new javax.swing.text.MaskFormatter("##/##/####");        
            txfData = new javax.swing.JFormattedTextField(data);    
        }catch(Exception e){    }
        txfCombustivel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txfLitragem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfValor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txfKm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        txfKmAtual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abastecimento.png"))); // NOI18N
        jLabel1.setText("Abastecimento");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setText("ID");

        txfId.setEditable(false);
        txfId.setText("15");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("Usuário/Motorista");

        txfUsuario.setText("Mario");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Data");

        txfPosto.setText("Posto RVM Mogi Guaçu");

        btnNovo.setBackground(new java.awt.Color(33, 150, 243));
        btnNovo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maisp.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setMaximumSize(new java.awt.Dimension(97, 27));
        btnNovo.setMinimumSize(new java.awt.Dimension(97, 27));
        btnNovo.setPreferredSize(new java.awt.Dimension(97, 27));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(255, 64, 129));
        btnSalvar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salvarp.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txfPlaca.setEditable(false);
        txfPlaca.setText("DLH-8657");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setText("Placa do Veículo");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Posto de Combustível");

        txfData.setText("20/12/2020");
        txfData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfDataFocusLost(evt);
            }
        });

        txfCombustivel.setText("Gasolina");

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setText("Combustível");

        txfLitragem.setText("50");
        txfLitragem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfLitragemFocusLost(evt);
            }
        });
        txfLitragem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfLitragemKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel10.setText("Litragem");

        txfValor.setText("150,50");
        txfValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfValorFocusLost(evt);
            }
        });
        txfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfValorKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel11.setText("Valor");

        txfKm.setText("150,50");
        txfKm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfKmFocusLost(evt);
            }
        });
        txfKm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfKmKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setText("KM do Veiculo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros de Abastecimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setText("KM Atual");

        txfKmAtual.setEditable(false);
        txfKmAtual.setText("DLH-8657");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(90, 90, 90))
                            .addComponent(txfPosto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(txfLitragem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txfKm, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txfKmAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txfKmAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(txfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfLitragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txfId.setText(""+0);
        btnSalvar.setText("Salvar");
        limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(vcCtrol.addVeiculoCombustivel(txfId.getText(), veiculo.getId(), usuario.getId(), 
                                                     txfKm.getText(), txfPosto.getText(), txfCombustivel.getText(), 
                                                     txfLitragem.getText(), txfValor.getText(), txfData.getText())){
                
        
          limparCampos();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListValueChanged
        preencherSelectedListview();
    }//GEN-LAST:event_jListValueChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        jpRaiz.atualizarTela();
    }//GEN-LAST:event_formWindowClosed

    private void txfDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfDataFocusLost
        try{
            String dia = txfData.getText().substring(0, 2);
            String mes = txfData.getText().substring(3, 5);
            String ano = txfData.getText().substring(6);

            Calendar calendar = new GregorianCalendar();
            calendar.setLenient(false);
            calendar.set(Integer.parseInt(ano), Integer.parseInt(mes)-1, Integer.parseInt(dia));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Informe uma data válida!", "Valor inválido",JOptionPane.WARNING_MESSAGE);
            txfData.setText(new Auxiliar().getDataString());
        }
    }//GEN-LAST:event_txfDataFocusLost

    private void txfValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfValorFocusLost
       try{
           float valor = new Auxiliar().StringToFloat(txfValor.getText());
           txfValor.setText(valor+"");
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Informe um valor numérico válido", "Valor inválido",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_txfValorFocusLost

    private void txfLitragemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfLitragemFocusLost
        try{
           float valor = new Auxiliar().StringToFloat(txfLitragem.getText());
           txfLitragem.setText(valor+"");
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Informe um valor numérico válido", "Valor inválido",JOptionPane.WARNING_MESSAGE);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_txfLitragemFocusLost

    private void txfKmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfKmFocusLost
        try{
            int valor = Integer.parseInt(txfKm.getText());
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Informe um valor numérico válido", "Valor inválido",JOptionPane.WARNING_MESSAGE);
            txfKm.setText("");
       }
    }//GEN-LAST:event_txfKmFocusLost

    private void txfLitragemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfLitragemKeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txfLitragemKeyTyped

    private void txfKmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfKmKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txfKmKeyTyped

    private void txfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorKeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txfValorKeyTyped
   
    
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
            java.util.logging.Logger.getLogger(jdAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdAbastecimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txfCombustivel;
    private javax.swing.JTextField txfData;
    private javax.swing.JTextField txfId;
    private javax.swing.JTextField txfKm;
    private javax.swing.JTextField txfKmAtual;
    private javax.swing.JTextField txfLitragem;
    private javax.swing.JTextField txfPlaca;
    private javax.swing.JTextField txfPosto;
    private javax.swing.JTextField txfUsuario;
    private javax.swing.JTextField txfValor;
    // End of variables declaration//GEN-END:variables
}
