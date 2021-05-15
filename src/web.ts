import { WebPlugin } from '@capacitor/core';

import type { Desmp3Plugin } from './definitions';

export class Desmp3Web extends WebPlugin implements Desmp3Plugin {
  async start(options: { value: string }): Promise<{ value: string }> {
    console.log('start', options);
    return options;
  }
  async pause(options: { value: string }): Promise<{ value: string }> {
    console.log('pause', options);
    return options;
  }

  async stop(options: { value: string }): Promise<{ value: string }> {
    console.log('stop', options);
    return options;
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

}
