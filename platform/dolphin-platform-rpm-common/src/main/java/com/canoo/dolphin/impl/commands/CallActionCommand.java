/*
 * Copyright 2015-2017 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.canoo.dolphin.impl.commands;

import com.canoo.dolphin.impl.PlatformRemotingConstants;
import com.canoo.impl.platform.core.Assert;
import org.opendolphin.core.comm.Command;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class CallActionCommand extends Command {

    private String controllerId;

    private String actionName;

    private final Map<String, Object> params = new HashMap<>();

    public CallActionCommand() {
        super(PlatformRemotingConstants.CALL_ACTION_COMMAND_NAME);
    }

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(final String controllerId) {
        Assert.requireNonBlank(controllerId, "controllerId");
        this.controllerId = controllerId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(final String actionName) {
        Assert.requireNonBlank(actionName, "actionName");
        this.actionName = actionName;
    }

    public Map<String, Object> getParams() {
        return Collections.unmodifiableMap(params);
    }

    public void addParam(final String name, final Object value) {
        Assert.requireNonBlank(name, "name");
        params.put(name, value);
    }
}

