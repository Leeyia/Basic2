package android.arch.leeyi.db;
/*
 * Copyright (C) 2017 meikoz, http://basic2it.cc/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "token")
public class Token {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String access_token;
    public String refresh_token;
    public long time_millis;

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", time_millis=" + time_millis +
                '}';
    }
}
