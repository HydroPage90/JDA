/*
 * Copyright 2015-2020 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.events.guild.voice;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;

import javax.annotation.Nonnull;

/**
 * Indicates that a {@link net.dv8tion.jda.api.entities.Member Member} was (un-)deafened.
 * <br>Combines {@link net.dv8tion.jda.api.events.guild.voice.GuildVoiceGuildDeafenEvent GuildVoiceGuildDeafenEvent}
 * and {@link net.dv8tion.jda.api.events.guild.voice.GuildVoiceSelfDeafenEvent GuildVoiceSelfDeafenEvent}!
 *
 * <p>Can be used to detect when a member is deafened or un-deafened.
 *
 * <h2>Requirements</h2>
 *
 * <p>This event requires the {@link net.dv8tion.jda.api.utils.cache.CacheFlag#VOICE_STATE VOICE_STATE} CacheFlag to be enabled, which requires
 * the {@link net.dv8tion.jda.api.requests.GatewayIntent#GUILD_VOICE_STATES GUILD_VOICE_STATES} intent.
 *
 * <br>{@link net.dv8tion.jda.api.JDABuilder#createLight(String) createLight(String)} disables that CacheFlag by default!
 *
 * <p>The {@link net.dv8tion.jda.api.entities.Member Member} must be cached for this event to fire for the Member in question.
 */
public class GuildVoiceDeafenEvent extends GenericGuildVoiceEvent
{
    protected final boolean deafened;

    public GuildVoiceDeafenEvent(@Nonnull JDA api, long responseNumber, @Nonnull Member member)
    {
        super(api, responseNumber, member);
        this.deafened = member.getVoiceState().isDeafened();
    }

    /**
     * Whether the member was deafened in this event.
     *
     * @return True, if the member was deafened with this event
     *         <br>False, if the member was un-deafened in this event
     */
    public boolean isDeafened()
    {
        return deafened;
    }
}
