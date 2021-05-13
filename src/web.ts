import { WebPlugin } from '@capacitor/core';

import type { Desmp3Plugin } from './definitions';

export class Desmp3Web extends WebPlugin implements Desmp3Plugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
