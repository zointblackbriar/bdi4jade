//----------------------------------------------------------------------------
// Copyright (C) 2011  Ingrid Nunes, et al.
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
// http://www.inf.puc-rio.br/~ionunes/
//
//----------------------------------------------------------------------------

package br.pucrio.inf.les.bdi4jade.examples.blocksworld.plan;

import jade.core.behaviours.Behaviour;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.pucrio.inf.les.bdi4jade.examples.blocksworld.BlocksWorldCapability;
import br.pucrio.inf.les.bdi4jade.examples.blocksworld.domain.On;
import br.pucrio.inf.les.bdi4jade.examples.blocksworld.goal.AchieveBlocksStacked;
import br.pucrio.inf.les.bdi4jade.plan.PlanBody;
import br.pucrio.inf.les.bdi4jade.plan.PlanInstance;
import br.pucrio.inf.les.bdi4jade.plan.PlanInstance.EndState;
import br.pucrio.inf.les.bdi4jade.util.goal.BeliefSetValueGoal;

/**
 * @author ingrid
 * 
 */
public class TopLevelPlanBody extends Behaviour implements PlanBody {

	private static final long serialVersionUID = -5919677537834351951L;

	private int counter;
	private Log log;
	private PlanInstance planInstance;
	private On[] target;

	public TopLevelPlanBody() {
		this.counter = 0;
		this.log = LogFactory.getLog(this.getClass());
	}

	@Override
	public void action() {
		if (counter != 0) {
			if ((planInstance.getGoalEvent() == null)) {
				return;
			}
		}
		if (counter != target.length) {
			planInstance.dispatchSubgoalAndListen(new BeliefSetValueGoal<On>(
					BlocksWorldCapability.BELIEF_ON, target[counter]));
		}
		counter++;
	}

	@Override
	public boolean done() {
		return counter > target.length;
	}

	@Override
	public EndState getEndState() {
		return (counter > target.length) ? EndState.SUCCESSFUL : null;
	}

	@Override
	public void init(PlanInstance planInstance) {
		this.planInstance = planInstance;
		this.target = ((AchieveBlocksStacked) planInstance.getGoal())
				.getTarget();
	}

	@Override
	public int onEnd() {
		log.info("World Model at end is:");
		log.info(planInstance.getBeliefBase());
		return super.onEnd();
	}

	@Override
	public void onStart() {
		log.info("World Model at start is:");
		log.info(planInstance.getBeliefBase());
	}

}