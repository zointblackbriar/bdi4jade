//----------------------------------------------------------------------------
// Copyright (C) 2013  Ingrid Nunes
// 
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
// 
// To contact the authors:
// http://inf.ufrgs.br/~ingridnunes/bdi4jade/
//
//----------------------------------------------------------------------------

package bdi4jade.examples.template.plan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bdi4jade.examples.planselection.Softgoals;
import bdi4jade.examples.template.Constants;
import bdi4jade.examples.template.goal.MyGoal;
import bdi4jade.plan.PlanContribution;
import bdi4jade.softgoal.Softgoal;
import bdi4jade.util.plan.SimplePlan;

/**
 * @author ingrid
 * 
 */
public class MyPlan2 extends SimplePlan {

	public MyPlan2() {
		super(MyGoal.class, MyPlan2Body.class);

		Map<Softgoal, List<PlanContribution>> contributions = (Map<Softgoal, List<PlanContribution>>) getMetadata(DefaultMetadata.CONTRIBUTIONS);
		List<PlanContribution> sgContributions = null;

		sgContributions = new ArrayList<PlanContribution>();
		sgContributions.add(new PlanContribution(Constants.Softgoal1, 0.3, 0.0));
		sgContributions.add(new PlanContribution(Constants.Softgoal2, 0.7, 1.0));
		contributions.put(Softgoals.SAFETY, sgContributions);

		sgContributions = new ArrayList<PlanContribution>();
		sgContributions.add(new PlanContribution(Constants.Softgoal1, 0.5, 0.0));
		sgContributions.add(new PlanContribution(Constants.Softgoal2, 0.5, 1.0));
		contributions.put(Softgoals.PERFORMANCE, sgContributions);
	}

}