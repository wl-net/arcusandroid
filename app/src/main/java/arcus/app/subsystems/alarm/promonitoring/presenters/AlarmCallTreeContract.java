/*
 *  Copyright 2019 Arcus Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package arcus.app.subsystems.alarm.promonitoring.presenters;

import arcus.cornea.common.PresentedView;
import arcus.cornea.common.Presenter;

import arcus.cornea.subsystem.calllist.CallListEntry;
import com.iris.client.model.PersonModel;

import java.util.List;



public class AlarmCallTreeContract {

    public interface AlarmCallListView extends PresentedView<List<CallListEntry>> {
        void onCallTreeTooBigError();
        void onCallTreeEntryMissingPinError(PersonModel personMissingPin);

        void updateViewWithEditableCallTree(List<CallListEntry> contacts);
    }

    interface AlarmCallListPresenter extends Presenter<AlarmCallListView> {
        void show();
        void edit();
        void save(List<CallListEntry> calltree, List<CallListEntry> activeEntries);
    }
}
