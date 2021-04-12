package repositories;

import javax.swing.table.DefaultTableModel;

import repositories.Data;
import models.Aporte;

public class FiltroHistorico {

	private DefaultTableModel model;
	private Aporte mdAporte;
	
	public FiltroHistorico(DefaultTableModel modelParam) {
		mdAporte = new Aporte();
		model = modelParam;
	}
	
	public void ativos(String ativos) {
	
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0;i<model.getRowCount();i++ ) {
			
			if( ativos.toLowerCase().contains( model.getValueAt(i,1).toString().toLowerCase() ) ) {
				
				modelSalva.addRow( getRow(i) );
				
			}
		}
		
		model = modelSalva;
		
	}
	
	public void tipos(String tipos) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			if( tipos.toLowerCase().contains( model.getValueAt(i,2).toString().toLowerCase() ) ) {
				
				modelSalva.addRow( getRow(i) );
				
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void valorMaiorIgual(String valor) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			String valorAporte = model.getValueAt(i,3).toString().replace("R$","").replace(",",".");
			
			if( Double.parseDouble(valorAporte) >= Double.parseDouble(valor.replace(",",".")) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void valorMenorIgual(String valor) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			String valorAporte = model.getValueAt(i,3).toString().replace("R$","").replace(",",".");
			
			if( Double.parseDouble(valorAporte) <= Double.parseDouble(valor.replace(",",".")) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void qtdeMaiorIgual(String qtde) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			if( Integer.parseInt(model.getValueAt(i,4).toString()) >= Integer.parseInt(qtde) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void qtdeMenorIgual(String qtde) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			if( Integer.parseInt(model.getValueAt(i,4).toString()) <= Integer.parseInt(qtde) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void subTotalMaiorIgual(String subTotal) {
	
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			String subTotalAporte = model.getValueAt(i,5).toString().replace("R$","").replace(",",".");
			
			if( Double.parseDouble(subTotalAporte) >= Double.parseDouble(subTotal.replace(",",".")) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void subTotalMenorIgual(String subTotal) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			String subTotalAporte = model.getValueAt(i,5).toString().replace("R$","").replace(",",".");
			
			if( Double.parseDouble(subTotalAporte) <= Double.parseDouble(subTotal.replace(",",".")) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void dataMaiorIgual(String data) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		Data dt = new Data(data);
		
		for( int i=0; i<model.getRowCount(); i++ ) {
		
			if( dt.comparaDatas(model.getValueAt(i,6).toString(),data,"maior_igual") ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void dataMenorIgual(String data) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		Data dt  = new Data(data);
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			if( dt.comparaDatas(model.getValueAt(i,6).toString(),data,"menor_igual") ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public void taxaMenorIgual(String taxa) {
		
		DefaultTableModel modelSalva = getModelAuxiliar();
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			String taxaAporte = model.getValueAt(i,7).toString().replace("%","").replace(",",".");
			
			if( Double.parseDouble(taxaAporte) <= Double.parseDouble(taxa.replace(",",".")) ) {
				modelSalva.addRow( getRow(i) );
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public String[] getRow(int i) {
		
		String[] objRow = new String[ model.getColumnCount() ];
		
		for( int j=0; j<model.getColumnCount(); j++ ) {
			objRow[ j ] = model.getValueAt(i,j).toString();
		}
		
		return objRow;
		
	}
	
	public DefaultTableModel getModelAuxiliar() {
		DefaultTableModel modelSalva = new DefaultTableModel();
		modelSalva.setColumnIdentifiers(mdAporte.getArrayNomesCampos());
		
		return modelSalva;
	}
	
	public DefaultTableModel getModel() {
		return model;
	}
	
}
