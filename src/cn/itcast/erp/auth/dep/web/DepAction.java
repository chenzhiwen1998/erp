package cn.itcast.erp.auth.dep.web;

import java.util.List;

import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.dep.vo.DepQueryModel;
import cn.itcast.erp.util.base.BaseAction;

public class DepAction extends BaseAction {
	public DepModel dm = new DepModel();
	public DepQueryModel dqm = new DepQueryModel();

	private DepEbi depEbi;

	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}

	// ��ת���б�ҳ��
	public String list() {
		setDataTotal(depEbi.getCount(dqm));
		List<DepModel> depList = depEbi.getAll(dqm, pageNum, pageCount);
		put("depList", depList);
		return LIST;
	}

	// ��ת������ҳ��
	public String input() {
		if (dm.getUuid() != null) {
			dm = depEbi.get(dm.getUuid());
		}
		return INPUT;
	}

	// ���ӹ���
	public String save() {
		if (dm.getUuid() == null) {
			depEbi.save(dm);
		} else {
			depEbi.update(dm);
		}
		return TO_LIST;
	}

	// ɾ������
	public String delete() {
		depEbi.delete(dm);
		return TO_LIST;
	}

}

/*
 * package cn.itcast.erp.auth.dep.web;
 * 
 * import java.util.List;
 * 
 * import cn.itcast.erp.auth.dep.business.depebi.DepEbi; import
 * cn.itcast.erp.auth.dep.vo.DepModel; import
 * cn.itcast.erp.auth.dep.vo.DepQueryModel; import
 * cn.itcast.erp.util.base.BaseAction;
 * 
 * public class DepAction extends BaseAction {
 * 
 * public DepModel dm = new DepModel();
 * 
 * public DepQueryModel dqm = new DepQueryModel();
 * 
 * private DepEbi depEbi;
 * 
 * public void setDepEbi(DepEbi depEbi) { this.depEbi = depEbi; }
 * 
 * public String list() { dataTotal = depEbi.getCount(dqm); List<DepModel>
 * depList = depEbi.getAll(dqm, pageNum, pageCount); put("depList", depList);
 * return "list"; }
 * 
 * public String input() { if (dm.getUuid() != null) { dm =
 * depEbi.get(dm.getUuid()); } return INPUT; }
 * 
 * /* public String save() { if (dm.getUuid() == null) { depEbi.save(dm); } else
 * { depEbi.update(dm); } return TO_LIST; }
 *//**
 * ɾ������
 * 
 * @return
 */
/*
 * public String delete() { depEbi.delete(dm); return TO_LIST; }
 * 
 * 
 * public Integer pageNum = 1; public Integer pageCount = 2; public Integer
 * maxPage = 0; public Integer dataTotal = 0;
 *//**
 * ������ѯ����
 * 
 * @return
 */
/*
 * 
 * public String queryList() { List<DepModel> depList = depEbi.getAll(dqm);
 * ActionContext.getContext().put("depList", depList); return "list"; }
 * 
 * }
 */