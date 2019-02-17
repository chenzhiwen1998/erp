package cn.itcast.erp.invoice.supplier.web;

import java.util.List;

import cn.itcast.erp.invoice.supplier.business.ebi.SupplierEbi;
import cn.itcast.erp.invoice.supplier.vo.SupplierModel;
import cn.itcast.erp.invoice.supplier.vo.SupplierQueryModel;
import cn.itcast.erp.util.base.BaseAction;

public class SupplierAction extends BaseAction {
	public SupplierModel sm = new SupplierModel();
	public SupplierQueryModel sqm = new SupplierQueryModel();

	private SupplierEbi supplierEbi;

	public void setSupplierEbi(SupplierEbi supplierEbi) {
		this.supplierEbi = supplierEbi;
	}

	// ��ת���б�ҳ��
	public String list() {
		setDataTotal(supplierEbi.getCount(sqm));
		List<SupplierModel> supplierList = supplierEbi.getAll(sqm, pageNum, pageCount);
		put("supplierList", supplierList);
		return LIST;
	}

	// ��ת������ҳ��
	public String input() {
		if (sm.getUuid() != null) {
			sm = supplierEbi.get(sm.getUuid());
		}
		return INPUT;
	}

	// ���ӹ���
	public String save() {
		if (sm.getUuid() == null) {
			supplierEbi.save(sm);
		} else {
			supplierEbi.update(sm);
		}
		return TO_LIST;
	}

	// ɾ��
	public String delete() {
		supplierEbi.delete(sm);
		return TO_LIST;
	}

}