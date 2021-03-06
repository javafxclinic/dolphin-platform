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
package org.opendolphin.core.client;

import org.opendolphin.core.BasePresentationModel;

import java.util.List;

import static org.opendolphin.RemotingConstants.CLIENT_PM_AUTO_ID_SUFFIX;

public final class ClientPresentationModel extends BasePresentationModel<ClientAttribute> {

    private static long instanceCount = 0;

    private boolean clientSideOnly = false;

    public ClientPresentationModel(final List<ClientAttribute> attributes) {
        this(null, attributes);
    }

    /**
     * @param id if id is null or empty, an auto-generated id will be used
     */
    public ClientPresentationModel(final String id, final List<ClientAttribute> attributes) {
        super(createUniqueId(id), attributes);
        if (id != null && id.endsWith(CLIENT_PM_AUTO_ID_SUFFIX)) {
            throw new IllegalArgumentException("presentation model with self-provided id \'" + id + "\' may not end with suffix \'" + CLIENT_PM_AUTO_ID_SUFFIX + "\' since that is reserved.");
        }
    }

    private static String createUniqueId(final String id) {
        return (id != null && id.length() > 0) ? id : "" + instanceCount++ + CLIENT_PM_AUTO_ID_SUFFIX;
    }

    public boolean isClientSideOnly() {
        return clientSideOnly;
    }

    public void setClientSideOnly(final boolean clientSideOnly) {
        this.clientSideOnly = clientSideOnly;
    }

}
