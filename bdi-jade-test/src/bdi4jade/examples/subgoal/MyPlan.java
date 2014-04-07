//----------------------------------------------------------------------------
// Copyright (C) 2011  Ingrid Nunes
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

package bdi4jade.examples.subgoal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bdi4jade.plan.Plan.EndState;
import bdi4jade.plan.PlanBody;

/**
 * @author ingrid
 * 
 */
public class MyPlan extends PlanBody {

	private static final long serialVersionUID = -5432560989511973914L;

	private int counter;
	private Log log = LogFactory.getLog(this.getClass());

	@Override
	public void action() {
		log.info("Plan executing... counter " + counter);
		counter++;

		if (counter >= 10) {
			setEndState(EndState.SUCCESSFUL);
		}
	}

	@Override
	public void onStart() {
		this.counter = 0;
	}

}