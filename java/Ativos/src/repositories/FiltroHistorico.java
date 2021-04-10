package repositories;

import javax.swing.table.DefaultTableModel;

import models.Aporte;

public class FiltroHistorico {

	private DefaultTableModel model;
	private Aporte mdAporte;
	
	public FiltroHistorico(DefaultTableModel modelParam) {
		mdAporte = new Aporte();
		model = modelParam;
	}
	
	public void filtrarAtivos(String ativos) {
	
		DefaultTableModel modelSalva = new DefaultTableModel();
		modelSalva.setColumnIdentifiers( mdAporte.getArrayNomesCampos() );
		
		for( int i=0;i<model.getRowCount();i++ ) {
			
			if( ativos.toLowerCase().contains( model.getValueAt(i,1).toString().toLowerCase() ) ) {
				
				String[] objRow = new String[ model.getColumnCount() ];
				
				for( int j=0;j<model.getColumnCount();j++ ) {
					objRow[j] = model.getValueAt(i,j).toString();
				}
				
				modelSalva.addRow(objRow);
			}
		}
		
		model = modelSalva;
		
	}
	
	public void filtrarTipos(String tipos) {
		
		DefaultTableModel modelSalva = new DefaultTableModel();
		modelSalva.setColumnIdentifiers(mdAporte.getArrayNomesCampos());
		
		for( int i=0; i<model.getRowCount(); i++ ) {
			
			if( tipos.toLowerCase().contains( model.getValueAt(i,2).toString().toLowerCase() ) ) {
				
				String[] arrRow = new String[ model.getColumnCount() ];
				
				for( int j=0; j<model.getColumnCount(); j++ ) {
					arrRow[j] = model.getValueAt(i,j).toString();
				}
				
				modelSalva.addRow(arrRow);
				
			}
			
		}
		
		model = modelSalva;
		
	}
	
	public DefaultTableModel getModel() {
		return model;
	}
	
}
